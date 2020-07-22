package pt.ptcris.sync.util;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response.Status;

public class Utils {
	public static String formatMethod (String method) {
		return "|action:"+ method + "|";
	}	
	public static String formatOrcid (String orcid) {
		return "|orcid:"+ orcid + "|";
	}
	public static String formatStatus (Status status) {
		return "|response.status:" + status.getStatusCode() + "|";
	}
	public static String formatPTCRISyncStatus (String status) {
		return "|status:" + status + "|";
	}
	public static String formatPTCRISyncError (String error) {
		return "|error:" + error + "|";
	}
	public static String formatIP (String ip) {
		return "|IP:" + ip + "|";
	}
	public static String formatProgressResult (String result) {
		return  "|"+ ParseLog.progressMethodName + ":" + result + "|";
	}
	
	public static String escapeDelimiter (String message) {
		return  message.replace("|", "\\|");
	}
	
	public static String removeDelimiter (String message) {
		return  message.replace("|", "");
	}	
	
	public static String getRemoteAddress (HttpServletRequest request) {
		String ipAddress = request.getHeader("X-FORWARDED-FOR"); 
		if (ipAddress == null) { 
			ipAddress = request.getRemoteAddr(); 
		}
		return ipAddress;
	}
}
