package io.swagger.api;

import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.models.*;

import io.swagger.models.auth.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;


public class Bootstrap extends HttpServlet {
  @Override
  public void init(ServletConfig config) throws ServletException {
    Info info = new Info()
      .title("PTCRISync webservice")
      .description("This is an interface for PTCRISync library.")
      .termsOfService("")
      .version("0.0.1-alpha")
      .contact(new Contact()
        .email("support@ptcris.pt"))
      .license(new License()
        .name("")
        .url(""));

    ServletContext context = config.getServletContext();
    Swagger swagger = new Swagger().info(info);
    
    //API key
    swagger.securityDefinition("apikey", new ApiKeyAuthDefinition("apikey", In.HEADER));

    swagger.tag(new Tag()
    	      .name("work")
    	      .description("Work methods")
    	      .externalDocs(new ExternalDocs("Find out more about PTCRISync", "http://github.com")));
    
    new SwaggerContextService().withServletConfig(config).updateSwagger(swagger);
  }
}
