package pt.ptcris.sync.map;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;

import org.um.dsi.gavea.orcid.model.common.FuzzyDate;
import org.um.dsi.gavea.orcid.model.common.FuzzyDate.*;
import org.um.dsi.gavea.orcid.model.common.RelationshipType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactory;
import org.um.dsi.gavea.orcid.model.common.ExternalId;
import org.um.dsi.gavea.orcid.model.common.ExternalIds;
import org.um.dsi.gavea.orcid.model.work.*;
import org.xml.sax.SAXException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import io.swagger.api.impl.OrcidApiServiceImpl;
import io.swagger.converter.ModelConverterContextImpl;
import io.swagger.converter.ModelConverters;
import io.swagger.model.Day;
import io.swagger.model.WorkList;
import pt.ptcris.sync.exception.WorkSchemaException;
import pt.ptcris.sync.util.PropertiesLoader;

public class WorkOrcidMap {
	private static final Logger _log = LoggerFactory.getLogger(WorkOrcidMap.class);

	private static final Properties properties = PropertiesLoader.getInstance().getProperties();
	private static final String xsdFileName = properties.getProperty("work.schema.file");
	private static final String xsdCustomFileName = properties.getProperty("custom.schema.file");


	public static Work map(io.swagger.model.Work swaggerWork) throws WorkSchemaException {
		return map2(swaggerWork);
	}

	private static Work map2_rc1(io.swagger.model.Work swaggerWork) {
		Work work = new Work();

		// Title
		WorkTitle workTitle = new WorkTitle();
		workTitle.setTitle(swaggerWork.getTitle().getTitle().getValue());

		// Identifiers
		ExternalIds workIdentifiers = new ExternalIds();

		io.swagger.model.ExternalIDs swaggerExternalIds = swaggerWork.getExternalIds();

		List<ExternalId> externalIdentifierList = new LinkedList<ExternalId>();
		for (io.swagger.model.ExternalID swaggerWorkExternalId : swaggerExternalIds.getExternalId()) {
			ExternalId externalIdentifier = new ExternalId();

			externalIdentifier.setExternalIdValue(swaggerWorkExternalId.getExternalIdValue());
			externalIdentifier.setExternalIdType(swaggerWorkExternalId.getExternalIdType());
			externalIdentifier.setExternalIdUrl(swaggerWorkExternalId.getExternalIdUrl().getValue());
			RelationshipType relationShipType = RelationshipType
					.valueOf(swaggerWorkExternalId.getExternalIdRelationship().toString());
			externalIdentifier.setExternalIdRelationship(relationShipType);

			externalIdentifierList.add(externalIdentifier);
		}
		workIdentifiers.setExternalId(externalIdentifierList);

		// Type
		WorkType workType = WorkType.valueOf(swaggerWork.getType().toString());

		if (swaggerWork.getPublicationDate() != null) {
			// Publication date
			io.swagger.model.PublicationDate swaggerPubDate = swaggerWork.getPublicationDate();

			FuzzyDate.Year pubDateYear = new FuzzyDate.Year(swaggerPubDate.getYear().getValue());
			FuzzyDate.Month pubDateMonth = new FuzzyDate.Month(swaggerPubDate.getMonth().getValue());
			FuzzyDate.Day pubDateDay = new FuzzyDate.Day(swaggerPubDate.getDay().getValue());

			FuzzyDate publicationDate = new FuzzyDate(pubDateYear, pubDateMonth, pubDateDay);

			// Set work data
			work.setPublicationDate(publicationDate);
		}

		work.setType(workType);
		work.setExternalIds(workIdentifiers);
		work.setTitle(workTitle);

		return work;
	}

	private static Work map2(io.swagger.model.Work swaggerWork) throws WorkSchemaException {
		String fileName = "swagger2orcid-v2.0_map.xsl";

		ClassLoader classLoader = WorkOrcidMap.class.getClassLoader();
		Source xsl = new StreamSource(new File(classLoader.getResource(fileName).getFile()));
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		Result xmlOutput = new StreamResult(result);
		Work work = null;

		XmlMapper xmlMapper = new XmlMapper();
		try {

			Source xmlInput = new StreamSource(new ByteArrayInputStream(xmlMapper.writeValueAsBytes(swaggerWork)));
			// DocumentBuilder builder =
			// DocumentBuilderFactory.newInstance().newDocumentBuilder();
			/*if (validateXMLSchema(xsdCustomFileName,xmlInput)) {
				_log.debug(xsdCustomFileName);
			}*/

			_log.debug("RESULT:\n" + xmlMapper.writeValueAsString(swaggerWork));

			Transformer transformer = TransformerFactory.newInstance().newTransformer(xsl);
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

			transformer.transform(xmlInput, xmlOutput);

			_log.debug("TRANSFORMED RESULT:\n" + result.toString());

			// Work newWork =
			// xmlMapper.convertValue(swaggerWork,Work.class);
			// System.out.println(newWork.toString());

			if (validateXMLSchema(xsdFileName,new StreamSource(new ByteArrayInputStream(result.toByteArray())))) {
				JAXBContext context;

				context = JAXBContext.newInstance(Work.class);
				Unmarshaller un = context.createUnmarshaller();

				StringReader reader = new StringReader(result.toString());
				work = (Work) un.unmarshal(reader);
				reader.close();
				//System.out.println(work.toString());

			}

		} catch (JAXBException | IOException | TransformerFactoryConfigurationError | TransformerException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			throw new WorkSchemaException (e.getMessage());
		}

		// TODO: error on mapping directly
		// xmlMapper.convertValue(swaggerWork,Work.class);

		return work;
	}

	public static boolean validateXMLSchema(String xsdPath, Source xmlInput) throws WorkSchemaException {

		try {
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(new File(xsdPath));
			Validator validator = schema.newValidator();
			validator.validate(xmlInput);
			return true;
		} catch (IOException | SAXException e) {
			throw new WorkSchemaException(e.getMessage());
		}
	}
}
