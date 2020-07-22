package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.ApiResponseMessage;
import io.swagger.model.WorkList;
import pt.ptcris.sync.util.Utils;
import io.swagger.model.WorkExportResults;
import io.swagger.model.WorkInvalidResults;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-21T16:55:10.796Z")
public abstract class OrcidApiService {
	private String ipAddress = "";
	private String methodName = "";

    public abstract Response getProgress(String orcid, HttpServletRequest requestContext) throws NotFoundException;
    public abstract Response postWorkCounter(String orcid,String token,WorkList localWorks, HttpServletRequest requestContext) throws NotFoundException;
    public abstract Response postWorkExport(String orcid,String token,Boolean force,WorkList localWorks, HttpServletRequest requestContext) throws NotFoundException;
    public abstract Response postWorkImport(String orcid,String token,Boolean update,WorkList localWorks, HttpServletRequest requestContext) throws NotFoundException;
    public abstract Response postWorkImportInvalid(String orcid,String token,WorkList localWorks, HttpServletRequest requestContext) throws NotFoundException;
    
    public void setIPAddress (String ipAddress) {
    	this.ipAddress = ipAddress;
    }
    
    public String getIPAddress () {
    	return this.ipAddress;
    }
    
    public void setMethodName (String methodName) {
    	this.methodName = methodName;
    }
    
    public String getMethodName () {
    	return this.methodName;
    }
}
