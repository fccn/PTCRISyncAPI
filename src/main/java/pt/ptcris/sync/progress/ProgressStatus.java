package pt.ptcris.sync.progress;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProgressStatus {
	@JsonProperty("status-list")
	private StatusRecordsList statusRecordsList;
	
	@JsonProperty("date")
	private Date date = null;

	
	public ProgressStatus date (Date date) {
	    this.date = date;
	    return this;
	  }	
	
	/**
	 * Get date
	 * 
	 * @return date
	 **/
	@JsonProperty("date")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	public ProgressStatus statusRecordsList (StatusRecordsList statusRecordsList) {
	    this.statusRecordsList = statusRecordsList;
	    return this;
	}	
		
	/**
	 * Get progress status list
	 * 
	 * @return progressStatus
	 **/
	@JsonProperty("status-list")
	public StatusRecordsList getStatusRecordsList() {
		return statusRecordsList;
	}

	public void setStatusRecordsList(StatusRecordsList statusRecordsList) {
		this.statusRecordsList = statusRecordsList;
	}

}
