package pt.ptcris.sync.progress;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "progress-request")
@XmlAccessorType (XmlAccessType.FIELD)
public class ProgressRequest {
	String orcid;
	String webHookURL;
	
	public String getWebHookURL() {
        return webHookURL;
    }
 
    public void setWebHookURL(String webHookURL) {
        this.webHookURL = webHookURL;
    }
    
    public String getOrcid() {
        return orcid;
    }
 
    public void setOrcid(String orcid) {
        this.orcid = orcid;
    }
    
}
