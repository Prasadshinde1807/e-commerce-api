package org.dnyanyog.dto;

public class UpdateUserResponse {
	
	private String responseCode;
	
	private String message;
	
	private UpdateUserRequest request;
	
	public String getCodeResponce() {
		return responseCode;
	}
	public void setCodeResponce(String codeResponce) {
		this.responseCode = codeResponce;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public UpdateUserRequest getRequest() {
		return request;
	}
	public void setRequest(UpdateUserRequest request) {
		this.request = request;
	}
}
