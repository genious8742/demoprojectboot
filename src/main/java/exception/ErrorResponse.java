package exception;

import java.sql.Date;

public class ErrorResponse {
	private Date timestamp;
	private String status;
	private String message;
	private String details;
	
	public ErrorResponse(java.util.Date date,String status,String message,String details) {
		this.timestamp=(Date) date;
		this.status = status;
		this.message = message;
		this.details =details;
		
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp =timestamp;
	}
	public String getStatus() {
		 return status;
	}
	public void getStatus(String status) {
		this.status = status;
	}
	public String setMessage() {
		return message;
		
	}
	public void getmessage() {
		this.message = message;
	}
	public String setdetails() {
		return details;
	}
	public void getdetails() {
		this.details = details;

	}
	}
