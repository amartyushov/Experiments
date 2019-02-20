package io.mart.tree.model.ignoreFields;

public class BasicClass {
	
	private long id;
	private String name;
	private String unnecessaryField;
	private long unnecessaryId;
	
	
	public long getId() {
		return id;
	}
	
	
	public BasicClass setId(long id) {
		this.id = id;
		return this;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public BasicClass setName(String name) {
		this.name = name;
		return this;
	}
	
	
	public String getUnnecessaryField() {
		return unnecessaryField;
	}
	
	
	public BasicClass setUnnecessaryField(String unnecessaryField) {
		this.unnecessaryField = unnecessaryField;
		return this;
	}
	
	
	public long getUnnecessaryId() {
		return unnecessaryId;
	}
	
	
	public BasicClass setUnnecessaryId(long unnecessaryId) {
		this.unnecessaryId = unnecessaryId;
		return this;
	}
	
	
	@Override
	public String toString() {
		return "BasicClass{" +
				"id=" + id +
				", name='" + name + '\'' +
				", unnecessaryField='" + unnecessaryField + '\'' +
				", unnecessaryId=" + unnecessaryId +
				'}';
	}
}
