package pt.ptcris.sync.progress;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pt.ptcris.handlers.ProgressHandler;
import pt.ptcris.sync.util.Utils;

public class ProgressHandlerImpl implements ProgressHandler {
	private static final Logger _log = LoggerFactory.getLogger(ProgressHandlerImpl.class);
	private String orcid = "";
	private int progress = 0;
	private int nRecords = 0;
	private String status = "";
	private Map<String,Integer> statusMap = new HashMap<String,Integer>();
	
	public ProgressHandlerImpl (String orcid) {
		this.orcid = orcid;
	}
	
	public void setOrcid(String orcid) {
		this.orcid = orcid;
	}
	
	@Override
	public void setProgress(int progress) {
		this.progress = progress;
		if (progress > 0) {
			this.nRecords++;
		}
		_log.trace(Utils.formatOrcid(orcid) + ": "+ progress + "%");
	}
	
	public int getProgress() {
		return progress;
	}

	@Override
	public void setCurrentStatus(String message) {	
		if (!this.status.equals(message)) {		
			statusMap.put(message, nRecords);
			this.progress = 0;
			this.nRecords = 0;
		}
	
		this.status = message;
		_log.debug(Utils.formatOrcid(orcid) + Utils.formatPTCRISyncStatus(message));
	}
	
	public String getCurrentStatus() {
		return this.status;
	}

	@Override
	public void sendError(String message) {
		_log.error(Utils.formatOrcid(orcid) + Utils.formatPTCRISyncError(message));
		
	}

	@Override
	public void done() {
		statusMap.put(status, nRecords);
		_log.info(Utils.formatOrcid(orcid) + Utils.formatProgressResult(this.toString()));
	}
	
	@Override
	public String toString() {
		String result = "";
		for (Map.Entry<String, Integer> entry : statusMap.entrySet()) {
		    String key = entry.getKey();
		    Object value = entry.getValue();
		    result += key+ ":" + value + ";"; 
		}
		return result;
	}

    @Override
    public void setCurrentStatus(String message, int size) {
        this.setCurrentStatus(message);
    }

    @Override
    public void step() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void step(int step) {
        // TODO Auto-generated method stub
        
    }

}
