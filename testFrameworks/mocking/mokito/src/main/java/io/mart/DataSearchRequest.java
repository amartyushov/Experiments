package io.mart;

import java.util.Date;

class DataSearchRequest {
	
	String id;
	
	Date updatedBefore;
	
	int length;
	
	
	public DataSearchRequest(String id, Date updatedBefore, int length) {
		this.id = id;
		this.updatedBefore = updatedBefore;
		this.length = length;
	}
	
	
	public String getId() {
		return id;
	}
	
	
	public Date getUpdatedBefore() {
		return updatedBefore;
	}
	
	
	public int getLength() {
		return length;
	}
}