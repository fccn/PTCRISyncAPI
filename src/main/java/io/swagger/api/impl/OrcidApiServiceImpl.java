package io.swagger.api.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.parser.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.um.dsi.gavea.orcid.client.OrcidAccessToken;
import org.um.dsi.gavea.orcid.client.exception.OrcidClientException;
import org.um.dsi.gavea.orcid.model.work.Work;
import org.um.dsi.gavea.orcid.model.work.WorkTitle;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import io.swagger.api.ApiResponseMessage;
import io.swagger.api.NotFoundException;
import io.swagger.api.OrcidApiService;
import io.swagger.model.WorkExportResults;
import io.swagger.model.WorkInvalidResult;
import io.swagger.model.WorkList;
import pt.ptcris.ORCIDClientImpl;
import pt.ptcris.PTCRISync;
import pt.ptcris.PTCRISyncResult;
import pt.ptcris.handlers.ProgressHandler;
import pt.ptcris.sync.exception.WorkSchemaException;
import pt.ptcris.sync.map.ExportSwaggerMap;
import pt.ptcris.sync.map.InvalidSwaggerMap;
import pt.ptcris.sync.map.WorkOrcidMap;
import pt.ptcris.sync.map.WorkSwaggerMap;
import pt.ptcris.sync.progress.ProgressHandlerImpl;
import pt.ptcris.sync.progress.ProgressRequest;
import pt.ptcris.sync.util.ParseLog;
import pt.ptcris.sync.util.PropertiesLoader;
import pt.ptcris.sync.util.Utils;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-17T10:22:03.563Z")
public class OrcidApiServiceImpl extends OrcidApiService {
	private static final Logger _log = LoggerFactory.getLogger(OrcidApiServiceImpl.class);
	private static final Properties properties = PropertiesLoader.getInstance().getProperties();
	private static final String orcidAPIURL = properties.getProperty("orcid.api_url");
	private static final String orcidClientId = properties.getProperty("orcid.client_id");
	private static final String orcidClientSecret = properties.getProperty("orcid.client_secret");
	private static final String orcidRedirectURL = properties.getProperty("orcid.redirect_url");
	private static final String orcidLoginURL = properties.getProperty("orcid.login_url");

	@Override
	public Response getProgress(String orcid, HttpServletRequest requestContext) throws NotFoundException {
		ProgressRequest progressRequest = new ProgressRequest();
		progressRequest.setOrcid(orcid);
		_log.info(Utils.formatMethod(this.getMethodName()) + Utils.formatIP(this.getIPAddress())
				+ Utils.formatOrcid(orcid) + Utils.formatStatus(Status.OK));
		
		String result = ParseLog.getOrcidProgressStatus(orcid);
		
		if (result.isEmpty()) {
			_log.error(Utils.formatMethod(this.getMethodName()) + Utils.formatIP(this.getIPAddress())
			+ Utils.formatOrcid(orcid) + Utils.formatStatus(Status.NO_CONTENT));
			return Response.status(Status.NO_CONTENT)
					.entity(new ApiResponseMessage(ApiResponseMessage.WARNING, ""))
					.build();
		}
		
		return Response.ok()
				.entity(new ApiResponseMessage(ApiResponseMessage.OK, result))
				.build();
	}

	@Override
	public Response postWorkCounter(String orcid, String token, WorkList localWorks, HttpServletRequest requestContext)
			throws NotFoundException {

		ProgressHandler progress = new ProgressHandlerImpl(orcid);
		OrcidAccessToken orcidToken = new OrcidAccessToken();
		orcidToken.setOrcid(orcid);
		orcidToken.setAccess_token(token);

		int counter = 0;

		ORCIDClientImpl client = defaultClient(orcidToken);
		try {
			List<Work> works = new LinkedList<Work>();
			for (io.swagger.model.Work localWork : localWorks) {
				works.add(WorkOrcidMap.map(localWork));
			}
			counter = PTCRISync.importWorkCounter(client, works, progress);
		} catch (WorkSchemaException e) {
			_log.error(Utils.formatMethod(this.getMethodName()) + Utils.formatIP(this.getIPAddress())
					+ Utils.formatOrcid(orcid) + e.getMessage() + Utils.formatStatus(Status.BAD_REQUEST));
			return Response.status(400).entity(new ApiResponseMessage(ApiResponseMessage.WARNING, e.getMessage()))
					.build();
		} catch (OrcidClientException e) {
			_log.error(Utils.formatMethod(this.getMethodName()) + Utils.formatIP(this.getIPAddress())
					+ Utils.formatOrcid(orcid) + e.getMessage() + e.getDeveloperMessage()
					+ Utils.formatStatus(Status.SERVICE_UNAVAILABLE));
			return Response.serverError()
					.entity(new ApiResponseMessage(ApiResponseMessage.ERROR, e.getMessage() + e.getDeveloperMessage()))
					.build();
		} catch (Exception e) {
			_log.error(Utils.formatMethod(this.getMethodName()) + Utils.formatIP(this.getIPAddress())
					+ Utils.formatOrcid(orcid) + e.getMessage() + Utils.formatStatus(Status.INTERNAL_SERVER_ERROR));
			return Response.serverError().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, e.getMessage()))
					.build();
		}

		_log.info(Utils.formatMethod(this.getMethodName()) + Utils.formatIP(this.getIPAddress())
				+ Utils.formatOrcid(orcid) + Utils.formatStatus(Status.OK));
		return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "" + counter)).build();

	}

	@Override
	public Response postWorkExport(String orcid, String token, Boolean force, WorkList localWorks,
			HttpServletRequest requestContext) throws NotFoundException {

		ProgressHandler progress = new ProgressHandlerImpl(orcid);
		OrcidAccessToken orcidToken = new OrcidAccessToken();
		orcidToken.setOrcid(orcid);
		orcidToken.setAccess_token(token);

		boolean atLeastOneError = false;
		WorkExportResults workExportResults = new WorkExportResults();

		ORCIDClientImpl client = defaultClient(orcidToken);
		try {

			List<Work> works = new LinkedList<Work>();
			for (io.swagger.model.Work localWork : localWorks) {
				try {
					works.add(WorkOrcidMap.map(localWork));
				} catch (WorkSchemaException e) {
					_log.error(Utils.formatMethod(this.getMethodName()) + Utils.formatIP(this.getIPAddress())
							+ Utils.formatOrcid(orcid) + e.getMessage() + Utils.formatStatus(Status.BAD_REQUEST));
					return Response.status(400)
							.entity(new ApiResponseMessage(ApiResponseMessage.WARNING, e.getMessage())).build();
				}
			}

			Map<BigInteger, PTCRISyncResult<Work>> result;

			if (force != null && force) {
				result = PTCRISync.exportWorksForced(client, works, progress);
			} else {
				result = PTCRISync.exportWorks(client, works, progress);
			}

			for (Map.Entry<BigInteger, PTCRISyncResult<Work>> entry : result.entrySet()) {

				BigInteger putCode = entry.getKey();
				PTCRISyncResult<Work> syncResult = entry.getValue();

				// add mapped value
				workExportResults.add(ExportSwaggerMap.map(entry));

				if (syncResult.exception != null) {
					atLeastOneError = true;
				}

			}

		} catch (OrcidClientException e) {
			_log.error(Utils.formatMethod(this.getMethodName()) + Utils.formatIP(this.getIPAddress())
					+ Utils.formatOrcid(orcid) + e.getMessage() + e.getDeveloperMessage()
					+ Utils.formatStatus(Status.SERVICE_UNAVAILABLE));
			return Response.serverError()
					.entity(new ApiResponseMessage(ApiResponseMessage.ERROR, e.getMessage() + e.getDeveloperMessage()))
					.build();
		} catch (Exception e) {
			_log.error(Utils.formatMethod(this.getMethodName()) + Utils.formatIP(this.getIPAddress())
					+ Utils.formatOrcid(orcid) + e.getMessage() + Utils.formatStatus(Status.INTERNAL_SERVER_ERROR));
			return Response.serverError().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, e.getMessage()))
					.build();
		}

		if (atLeastOneError) {
			// return created
			_log.warn(Utils.formatMethod(this.getMethodName()) + Utils.formatIP(this.getIPAddress())
					+ Utils.formatOrcid(orcid) + Utils.formatStatus(Status.CREATED));
			return Response.status(201).entity(workExportResults).build();
		} else {
			_log.info(Utils.formatMethod(this.getMethodName()) + Utils.formatIP(this.getIPAddress())
					+ Utils.formatOrcid(orcid) + Utils.formatStatus(Status.OK));
			return Response.ok().entity(workExportResults).build();
		}

	}

	@Override
	public Response postWorkImport(String orcid, String token, Boolean update, WorkList localWorks,
			HttpServletRequest requestContext) throws NotFoundException {

		ProgressHandler progress = new ProgressHandlerImpl(orcid);
		OrcidAccessToken orcidToken = new OrcidAccessToken();
		orcidToken.setOrcid(orcid);
		orcidToken.setAccess_token(token);

		WorkList resultMappedWorks = new WorkList();

		List<Work> orcidWorks;
		ORCIDClientImpl client = defaultClient(orcidToken);
		try {
			List<Work> works = new LinkedList<Work>();
			for (io.swagger.model.Work localWork : localWorks) {
				works.add(WorkOrcidMap.map(localWork));
			}

			if (update != null && update) {
				orcidWorks = PTCRISync.importWorkUpdates(client, works, progress);
			} else {
				orcidWorks = PTCRISync.importWorks(client, works, progress);
			}

			// Return list
			for (Work work : orcidWorks) {
				resultMappedWorks.add(WorkSwaggerMap.map(work));
			}

		} catch (WorkSchemaException e) {
			_log.error(Utils.formatMethod(this.getMethodName()) + Utils.formatIP(this.getIPAddress())
					+ Utils.formatOrcid(orcid) + e.getMessage() + Utils.formatStatus(Status.BAD_REQUEST));
			return Response.status(400).entity(new ApiResponseMessage(ApiResponseMessage.WARNING, e.getMessage()))
					.build();

		} catch (OrcidClientException e) {
			_log.error(Utils.formatMethod(this.getMethodName()) + Utils.formatIP(this.getIPAddress())
					+ Utils.formatOrcid(orcid) + e.getMessage() + e.getDeveloperMessage()
					+ Utils.formatStatus(Status.SERVICE_UNAVAILABLE));
			return Response.serverError()
					.entity(new ApiResponseMessage(ApiResponseMessage.ERROR, e.getMessage() + e.getDeveloperMessage()))
					.build();

		} catch (Exception e) {
			_log.error(Utils.formatMethod(this.getMethodName()) + Utils.formatIP(this.getIPAddress())
					+ Utils.formatOrcid(orcid) + e.getMessage() + Utils.formatStatus(Status.INTERNAL_SERVER_ERROR));
			return Response.serverError().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, e.getMessage()))
					.build();

		}
		_log.info(Utils.formatMethod(this.getMethodName()) + Utils.formatIP(this.getIPAddress())
				+ Utils.formatOrcid(orcid) + Utils.formatStatus(Status.OK));
		return Response.ok().entity(resultMappedWorks).build();
	}

	@Override
	public Response postWorkImportInvalid(String orcid, String token, WorkList localWorks,
			HttpServletRequest requestContext) throws NotFoundException {

		ProgressHandler progress = new ProgressHandlerImpl(orcid);
		OrcidAccessToken orcidToken = new OrcidAccessToken();
		orcidToken.setOrcid(orcid);
		orcidToken.setAccess_token(token);

		ORCIDClientImpl client = defaultClient(orcidToken);
		io.swagger.model.WorkInvalidResults invalidResults = null;
		try {
			List<Work> works = new LinkedList<Work>();
			for (io.swagger.model.Work localWork : localWorks) {
				works.add(WorkOrcidMap.map(localWork));
			}

			Map<Work, Set<String>> invalid = PTCRISync.importInvalidWorks(client, works, progress);
			invalidResults = InvalidSwaggerMap.map(invalid);

		} catch (WorkSchemaException e) {
			_log.error(Utils.formatMethod(this.getMethodName()) + Utils.formatIP(this.getIPAddress())
					+ Utils.formatOrcid(orcid) + e.getMessage() + Utils.formatStatus(Status.BAD_REQUEST));
			return Response.status(400).entity(new ApiResponseMessage(ApiResponseMessage.WARNING, e.getMessage()))
					.build();
		} catch (OrcidClientException e) {
			_log.error(Utils.formatMethod(this.getMethodName()) + Utils.formatIP(this.getIPAddress())
					+ Utils.formatOrcid(orcid) + e.getMessage() + e.getDeveloperMessage()
					+ Utils.formatStatus(Status.SERVICE_UNAVAILABLE));
			return Response.serverError()
					.entity(new ApiResponseMessage(ApiResponseMessage.ERROR, e.getMessage() + e.getDeveloperMessage()))
					.build();
		} catch (Exception e) {
			_log.error(Utils.formatMethod(this.getMethodName()) + Utils.formatIP(this.getIPAddress())
					+ Utils.formatOrcid(orcid) + e.getMessage() + Utils.formatStatus(Status.INTERNAL_SERVER_ERROR));
			return Response.serverError().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, e.getMessage()))
					.build();
		}
		_log.info(Utils.formatMethod(this.getMethodName()) + Utils.formatIP(this.getIPAddress())
				+ Utils.formatOrcid(orcid) + Utils.formatStatus(Status.OK));
		return Response.ok().entity(invalidResults).build();
	}

	private static ORCIDClientImpl defaultClient(OrcidAccessToken orcidToken) {
		return new ORCIDClientImpl(orcidLoginURL, orcidAPIURL, orcidClientId, orcidClientSecret, orcidRedirectURL,
				orcidToken);
	}

}
