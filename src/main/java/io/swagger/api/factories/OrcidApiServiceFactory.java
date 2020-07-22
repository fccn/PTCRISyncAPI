package io.swagger.api.factories;

import io.swagger.api.OrcidApiService;
import io.swagger.api.impl.OrcidApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-17T14:25:03.826Z")
public class OrcidApiServiceFactory {
    private final static OrcidApiService service = new OrcidApiServiceImpl();

    public static OrcidApiService getOrcidApi() {
        return service;
    }
}
