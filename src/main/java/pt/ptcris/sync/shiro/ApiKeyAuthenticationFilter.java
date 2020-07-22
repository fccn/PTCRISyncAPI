package pt.ptcris.sync.shiro;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.api.ApiResponseMessage;

public class ApiKeyAuthenticationFilter extends PermissionsAuthorizationFilter {
	private static final String APIKEY_HEADER = "apikey";
	private Map<String, String> tokens = new HashMap<String, String>();
	private String keyName = APIKEY_HEADER;

	public Map<String, String> getTokens() {
		return tokens;
	}

	public void setTokens(Map<String, String> tokens) {
		this.tokens = tokens;
	}
	
	public String getKeyName () {
		return keyName;
	}
	
	public void setKeyName (String keyName) {
		this.keyName = keyName;
	}

	/**
	 * This class's private logger.
	 */
	private static final Logger log = LoggerFactory.getLogger(ApiKeyAuthenticationFilter.class);

	protected String getApiKeyHeader(ServletRequest request) {
		HttpServletRequest httpRequest = WebUtils.toHttp(request);
		return httpRequest.getHeader(keyName);
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
		boolean loggedIn = false; // false by default or we wouldn't be in this
									// method

		// If subject is known but not authorized, redirect to the unauthorized
		// URL if there is one
		// If no unauthorized URL is specified, just return an unauthorized HTTP
		// status code
		// WebUtils.issueRedirect(request, response, unauthorizedUrl);
		WebUtils.toHttp(response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Forbidden: Invalid APIKey");
		return loggedIn;
	}

	@Override
	public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws IOException {
		boolean isPermitted = true;
		String key = this.getApiKeyHeader(request);
		isPermitted = this.tokens.containsValue(key);

		if (log.isTraceEnabled()) {
			log.trace("TOKEN '{}' has permission '{}'", key, String.valueOf(isPermitted));
		}

		// Verify if the token exists
		return isPermitted;

	}

}
