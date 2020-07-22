package pt.ptcris.sync.map;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import java.time.Instant;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import io.swagger.model.*;
import io.swagger.model.Contributor;
import io.swagger.model.ContributorAttributes.ContributorRoleEnum;
import io.swagger.model.ContributorAttributes.ContributorSequenceEnum;
import io.swagger.model.Country;
import io.swagger.model.CreatedDate;
import io.swagger.model.Country.ValueEnum;
import io.swagger.model.ExternalID;
import io.swagger.model.ExternalIDs;
import io.swagger.model.LastModifiedDate;
import io.swagger.model.PublicationDate;
import io.swagger.model.PublicationDate.MediaTypeEnum;
import io.swagger.model.SourceClientId;
import io.swagger.model.SourceName;
import io.swagger.model.SourceOrcid;
import io.swagger.model.Subtitle;
import io.swagger.model.Title;
import io.swagger.model.TranslatedTitle;
import io.swagger.model.Url;
import io.swagger.model.Work.TypeEnum;
import io.swagger.model.WorkContributors;
import io.swagger.model.WorkList;
import io.swagger.model.ExternalID.ExternalIdRelationshipEnum;
import io.swagger.models.Swagger;

public class WorkSwaggerMap {
	private static final Logger _log = LoggerFactory.getLogger(WorkSwaggerMap.class);

	public static io.swagger.model.Work map(org.um.dsi.gavea.orcid.model.work.Work work) {
		return map_v2(work);
	}

	private static io.swagger.model.Work map_v2(org.um.dsi.gavea.orcid.model.work.Work work) {
		io.swagger.model.Work swaggerWork = new io.swagger.model.Work();

		// CreatedDate - readonly
		// LastModifiedDate - readonly

		// Source
		if (work.getSource() != null) {
			swaggerWork.setSource(new io.swagger.model.Source());

			SourceClientId sourceClientId = new SourceClientId();
			if (work.getSource().getSourceClientId() != null) {
				sourceClientId.setHost(work.getSource().getSourceClientId().getHost());
				sourceClientId.setPath(work.getSource().getSourceClientId().getPath());
				sourceClientId.setUri(work.getSource().getSourceClientId().getUri());
			}

			SourceOrcid sourceOrcid = new SourceOrcid();
			if (work.getSource().getSourceOrcid() != null) {
				sourceOrcid.setHost(work.getSource().getSourceOrcid().getHost());
				sourceOrcid.setPath(work.getSource().getSourceOrcid().getPath());
				sourceOrcid.setUri(work.getSource().getSourceOrcid().getUri());
			}

			swaggerWork.getSource().setSourceClientId(sourceClientId);
			swaggerWork.getSource()
					.setSourceName(new SourceName().value(work.getSource().getSourceName().getContent()));
			swaggerWork.getSource().setSourceOrcid(sourceOrcid);
		}

		// Path - attribute
		if (work.getPath() != null) {
			swaggerWork.setPath(work.getPath());
		}

		// Visibility - attribute
		if (work.getVisibility() != null) {
			swaggerWork.setVisibility(io.swagger.model.Work.VisibilityEnum.fromValue(work.getVisibility().name()));
		}

		// Title
		if (work.getTitle() != null) {
			swaggerWork.setTitle(new io.swagger.model.WorkTitle());
			swaggerWork.getTitle().setTitle(new Title().value(work.getTitle().getTitle()));
			if (work.getTitle().getSubtitle() != null) {
				swaggerWork.getTitle().setSubtitle(new Subtitle().value(work.getTitle().getSubtitle().getContent()));
			}

			if (work.getTitle().getTranslatedTitle() != null) {
				swaggerWork.getTitle().setTranslatedTitle(
						new TranslatedTitle().value(work.getTitle().getTranslatedTitle().getValue()));
				swaggerWork.getTitle().getTranslatedTitle()
						.setLanguageCode(work.getTitle().getTranslatedTitle().getLanguageCode().name());
			}
		}

		// Identifiers
		swaggerWork.setExternalIds(new ExternalIDs());
		swaggerWork.getExternalIds().setExternalId(new LinkedList<io.swagger.model.ExternalID>());

		for (org.um.dsi.gavea.orcid.model.common.ExternalId externalIdList : work.getExternalIds().getExternalId()) {
			io.swagger.model.ExternalID swaggerWorkExternalId = new io.swagger.model.ExternalID();

			swaggerWorkExternalId.setExternalIdValue(externalIdList.getExternalIdValue());
			swaggerWorkExternalId.setExternalIdUrl(new io.swagger.model.Url().value(externalIdList.getExternalIdUrl()));
			swaggerWorkExternalId.setExternalIdType(externalIdList.getExternalIdType());
			swaggerWorkExternalId.setExternalIdRelationship(
					ExternalIdRelationshipEnum.fromValue(externalIdList.getExternalIdRelationship().name()));

			swaggerWork.getExternalIds().getExternalId().add(swaggerWorkExternalId);

		}

		// Type
		if (work.getType() != null) {
			swaggerWork.setType(TypeEnum.fromValue(work.getType().name()));
		}

		// Publication Date
		if (work.getPublicationDate() != null) {
			swaggerWork.setPublicationDate(new PublicationDate());
			if (work.getPublicationDate().getYear() != null) {
				swaggerWork.getPublicationDate()
						.setYear(new io.swagger.model.Year().value(work.getPublicationDate().getYear().getValue()));
			}
			if (work.getPublicationDate().getMonth() != null) {
				swaggerWork.getPublicationDate()
						.setMonth(new io.swagger.model.Month().value(work.getPublicationDate().getMonth().getValue()));
			}
			if (work.getPublicationDate().getDay() != null) {
				swaggerWork.getPublicationDate()
						.setDay(new io.swagger.model.Day().value(work.getPublicationDate().getDay().getValue()));
			}
		}

		// Contributors
		if (work.getContributors() != null) {
			swaggerWork.setContributors(new WorkContributors());
			List<Contributor> contributors = new LinkedList();

			for (org.um.dsi.gavea.orcid.model.work.Contributor contributor : work.getContributors().getContributor()) {
				Contributor swaggerContributor = new Contributor();

				if (contributor.getCreditName() != null) {
					swaggerContributor.setCreditName(new CreditName().value(contributor.getCreditName().getValue()));
				}

				if (contributor.getContributorOrcid() != null) {
					ContributorOrcid swaggerContributorOrcid = new ContributorOrcid();
					swaggerContributorOrcid.setHost(contributor.getContributorOrcid().getHost());
					swaggerContributorOrcid.setPath(contributor.getContributorOrcid().getPath());
					swaggerContributorOrcid.setUri(contributor.getContributorOrcid().getUri());
					swaggerContributor.setContributorOrcid(swaggerContributorOrcid);
				}

				if (contributor.getContributorAttributes() != null) {
					ContributorAttributes swaggerContributorAttributes = new ContributorAttributes();
					swaggerContributorAttributes.setContributorRole(ContributorRoleEnum
							.fromValue(contributor.getContributorAttributes().getContributorRole().name()));
					swaggerContributorAttributes.setContributorSequence(ContributorSequenceEnum
							.fromValue(contributor.getContributorAttributes().getContributorSequence().name()));
					swaggerContributor.setContributorAttributes(swaggerContributorAttributes);
				}

				if (contributor.getContributorEmail() != null) {
					swaggerContributor.setContributorEmail(
							new ContributorEmail().value(contributor.getContributorEmail().getValue()));
				}

				contributors.add(swaggerContributor);
			}

			swaggerWork.getContributors().setContributor(contributors);
		}

		// Citation
		if (work.getCitation() != null) {
			swaggerWork.setCitation(new Citation());

			if (work.getCitation().getCitationType() != null) {
				swaggerWork.getCitation().setCitationType(
						Citation.CitationTypeEnum.fromValue(work.getCitation().getCitationType().name()));
			}
			swaggerWork.getCitation().setCitationValue(work.getCitation().getCitationValue());
		}

		// Country
		if (work.getCountry() != null) {
			swaggerWork.setCountry(new Country().value(ValueEnum.fromValue(work.getCountry().getValue())));
		}

		// JournalTitle
		if (work.getJournalTitle() != null) {
			swaggerWork.setJournalTitle(new Title().value(work.getJournalTitle().getContent()));
		}

		// LanguageCode
		if (work.getLanguageCode() != null) {
			swaggerWork.setLanguageCode(work.getLanguageCode().name());
		}

		// ShortDescription
		if (work.getShortDescription() != null) {
			swaggerWork.setShortDescription(work.getShortDescription());
		}

		// Url
		if (work.getUrl() != null) {
			swaggerWork.setUrl(new Url().value(work.getUrl().getValue()));
		}

		return swaggerWork;
	}

	@Deprecated
	private static io.swagger.model.Work map_deprecated(org.um.dsi.gavea.orcid.model.work.Work work) {
		io.swagger.model.Work swaggerWork = new io.swagger.model.Work();
		XmlMapper xmlMapper = new XmlMapper();
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		Result xmlOutput = new StreamResult(result);

		ClassLoader classLoader = WorkSwaggerMap.class.getClassLoader();

		Source xsl = new StreamSource(new File(classLoader.getResource("orcid2swagger_map.xsl").getFile()));

		try {
			System.out.println(xmlMapper.writeValueAsString(work));

			Source xmlInput = new StreamSource(new ByteArrayInputStream(xmlMapper.writeValueAsBytes(work)));

			Transformer transformer = TransformerFactory.newInstance().newTransformer(xsl);
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

			transformer.transform(xmlInput, xmlOutput);

			
			_log.debug("TRANSFORMED RESULT:\n" + result.toString());

			Reader reader = new StringReader(result.toString());
			XMLInputFactory factory = XMLInputFactory.newInstance(); // Or
			// newFactory()

			JAXBContext context;

			context = JAXBContext.newInstance(io.swagger.model.Work.class);
			Unmarshaller un = context.createUnmarshaller();

			swaggerWork = xmlMapper.readValue(factory.createXMLStreamReader(reader), io.swagger.model.Work.class);
			// io.swagger.model.Work mappedWork = (io.swagger.model.Work)
			// un.unmarshal(reader);
			reader.close();

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return swaggerWork;
	}

}
