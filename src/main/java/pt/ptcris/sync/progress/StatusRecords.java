package pt.ptcris.sync.progress;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatusRecords {
	@JsonProperty("records-number")
	private int recordsNumber;
	@JsonProperty("status")
	private String status;

	public StatusRecords status(String status) {
		this.status = status;
		return this;
	}

	/**
	 * Get status
	 * 
	 * @return status
	 **/
	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public StatusRecords recordsNumber(Integer recordsNumber) {
		this.recordsNumber = recordsNumber;
		return this;
	}

	/**
	 * Get recordsNumber
	 * 
	 * @return recordsNumber
	 **/
	@JsonProperty("records-number")
	public Integer getRecordsNumber() {
		return recordsNumber;
	}

	public void setRecordsNumber(Integer recordsNumber) {
		this.recordsNumber = recordsNumber;
	}
}
