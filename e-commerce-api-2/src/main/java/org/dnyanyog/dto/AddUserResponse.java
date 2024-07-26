package org.dnyanyog.dto;

public class AddUserResponse {
	private String responceCode;
	private String message;
	private int userID; 
	private AddUserRequest request;
	public String getResponceCode() {
		return responceCode;
	}
	public void setResponceCode(String responceCode) {
		this.responceCode = responceCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public AddUserRequest getRequest() {
		return request;
	}
	public void setRequest(AddUserRequest request) {
		this.request = request;
	}
	
}
