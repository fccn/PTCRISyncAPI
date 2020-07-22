package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.OrcidApiService;
import io.swagger.api.factories.OrcidApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.ApiResponseMessage;
import io.swagger.model.WorkList;
import pt.ptcris.sync.util.Utils;
import io.swagger.model.WorkExportResults;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;

@Path("/{orcid}")
@io.swagger.annotations.Api(description = "the {orcid} API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-11T14:47:10.567Z")
public class OrcidApi {
	private final OrcidApiService delegate = OrcidApiServiceFactory.getOrcidApi();

	@GET
	@Path("/progress")

	@Produces({ "application/json" })
	@io.swagger.annotations.ApiOperation(value = "", notes = "Get the `Progress` of the process ", response = ApiResponseMessage.class, tags = {}, authorizations = @io.swagger.annotations.Authorization(value = "apikey"))
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = ApiResponseMessage.class) })
	public Response getProgress(@ApiParam(value = "person ORCID ID", required = true) @PathParam("orcid") String orcid,
			@Context HttpServletRequest requestContext) throws NotFoundException {
		delegate.setIPAddress(Utils.getRemoteAddress(requestContext));
		delegate.setMethodName(new Object(){}.getClass().getEnclosingMethod().getName());
		return delegate.getProgress(orcid, requestContext);
	}

	@POST
	@Path("/work/counter")

	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	@io.swagger.annotations.ApiOperation(value = "", notes = "Get the `Progress` of the process ", response = ApiResponseMessage.class, tags = {
			"work", }, authorizations = @io.swagger.annotations.Authorization(value = "apikey"))
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "Return the number of works to import (the counter)", response = ApiResponseMessage.class),

			@io.swagger.annotations.ApiResponse(code = 400, message = "Bad request - Invalid or missing data", response = ApiResponseMessage.class) })
	public Response postWorkCounter(
			@ApiParam(value = "person ORCID ID", required = true) @PathParam("orcid") String orcid,
			@ApiParam(value = "ORCID token", required = true) @HeaderParam("token") String token,
			@ApiParam(value = "All the Local Works") WorkList localWorks, @Context HttpServletRequest requestContext)
			throws NotFoundException {
		delegate.setIPAddress(Utils.getRemoteAddress(requestContext));
		delegate.setMethodName(new Object(){}.getClass().getEnclosingMethod().getName());
		return delegate.postWorkCounter(orcid, token, localWorks, requestContext);
	}

	@POST
	@Path("/work/export")

	@Consumes({ "application/json" })
	// @Produces({ "application/vnd.orcid+xml; qs=5", "application/orcid+xml;
	// qs=3", "application/xml", "application/vnd.orcid+json; qs=4",
	// "application/orcid+json; qs=2", "application/json" })
	@Produces({ "application/json" })
	@io.swagger.annotations.ApiOperation(value = "", notes = "Export all `Works` ", response = WorkExportResults.class, tags = {
			"work", }, authorizations = @io.swagger.annotations.Authorization(value = "apikey"))
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = WorkExportResults.class),

			@io.swagger.annotations.ApiResponse(code = 201, message = "Created - at least one", response = WorkExportResults.class),

			@io.swagger.annotations.ApiResponse(code = 202, message = "Accepted", response = ApiResponseMessage.class),

			@io.swagger.annotations.ApiResponse(code = 400, message = "Bad request - Invalid or missing data", response = ApiResponseMessage.class) })
	public Response postWorkExport(
			@ApiParam(value = "person ORCID ID", required = true) @PathParam("orcid") String orcid,
			@ApiParam(value = "ORCID token", required = true) @HeaderParam("token") String token,
			@ApiParam(value = "Export all `Works` forcing if even no updates exists") @QueryParam("force") Boolean force,
			@ApiParam(value = "Import updates, only get different works or Import invalid updates.") WorkList localWorks,
			@Context HttpServletRequest requestContext) throws NotFoundException {
		delegate.setIPAddress(Utils.getRemoteAddress(requestContext));
		delegate.setMethodName(new Object(){}.getClass().getEnclosingMethod().getName());
		return delegate.postWorkExport(orcid, token, force, localWorks, requestContext);
	}

	@POST
	@Path("/work/import")

	@Consumes({ "application/json" })
	// @Produces({ "application/vnd.orcid+xml; qs=5", "application/orcid+xml;
	// qs=3", "application/xml", "application/vnd.orcid+json; qs=4",
	// "application/orcid+json; qs=2", "application/json" })
	@Produces({ "application/json" })
	@io.swagger.annotations.ApiOperation(value = "", notes = "Import all `Works` ", response = WorkList.class, tags = {
			"work", }, authorizations = @io.swagger.annotations.Authorization(value = "apikey"))
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "Ok", response = WorkList.class),

			@io.swagger.annotations.ApiResponse(code = 202, message = "Accepted", response = ApiResponseMessage.class),

			@io.swagger.annotations.ApiResponse(code = 400, message = "Bad request - Invalid or missing data", response = ApiResponseMessage.class) })
	public Response postWorkImport(
			@ApiParam(value = "person ORCID ID", required = true) @PathParam("orcid") String orcid,
			@ApiParam(value = "ORCID token", required = true) @HeaderParam("token") String token,
			@ApiParam(value = "Import updates, only get different works.") @QueryParam("update") Boolean update,
			@ApiParam(value = "All Local Works (except for query update=true).") WorkList localWorks,
			@Context HttpServletRequest requestContext) throws NotFoundException {
		delegate.setIPAddress(Utils.getRemoteAddress(requestContext));
		delegate.setMethodName(new Object(){}.getClass().getEnclosingMethod().getName());
		return delegate.postWorkImport(orcid, token, update, localWorks, requestContext);
	}

	@POST
	@Path("/work/invalid")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	@io.swagger.annotations.ApiOperation(value = "", notes = "Import all `Works` ", response = WorkInvalidResults.class, authorizations = {
			@io.swagger.annotations.Authorization(value = "apikey") }, tags = { "work", })
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "Ok", response = WorkInvalidResults.class),

			@io.swagger.annotations.ApiResponse(code = 400, message = "Bad request - Invalid or missing data", response = ApiResponseMessage.class) })
	public Response postWorkImportInvalid(
			@ApiParam(value = "person ORCID ID", required = true) @PathParam("orcid") String orcid,
			@ApiParam(value = "ORCID token", required = true) @HeaderParam("token") String token,
			@ApiParam(value = "All Local Works.") WorkList localWorks, @Context HttpServletRequest requestContext)
			throws NotFoundException {
		delegate.setIPAddress(Utils.getRemoteAddress(requestContext));
		delegate.setMethodName(new Object(){}.getClass().getEnclosingMethod().getName());
		return delegate.postWorkImportInvalid(orcid, token, localWorks, requestContext);
	}
}
