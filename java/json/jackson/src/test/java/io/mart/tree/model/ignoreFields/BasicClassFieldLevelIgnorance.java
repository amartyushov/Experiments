package io.mart.tree.model.ignoreFields;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BasicClassFieldLevelIgnorance {
	
	private long id;
	private String name;
	
	@JsonIgnore
	private String unnecessaryField;
	
	/**
	 * This annotation can be on:
	 * field level
	 * getter
	 * setter
	 * of the field
	 */
	@JsonIgnore
	private long unnecessaryId;
	
	
	public long getId() {
		return id;
	}
	
	
	public BasicClassFieldLevelIgnorance setId(long id) {
		this.id = id;
		return this;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public BasicClassFieldLevelIgnorance setName(String name) {
		this.name = name;
		return this;
	}
	
	
	public String getUnnecessaryField() {
		return unnecessaryField;
	}
	
	
	public BasicClassFieldLevelIgnorance setUnnecessaryField(String unnecessaryField) {
		this.unnecessaryField = unnecessaryField;
		return this;
	}
	
//	@JsonIgnore
	public long getUnnecessaryId() {
		return unnecessaryId;
	}
	
//	@JsonIgnore
	public BasicClassFieldLevelIgnorance setUnnecessaryId(long unnecessaryId) {
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
