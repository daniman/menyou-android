package edu.mit.menyou.search;

import java.io.Serializable;

public class RestaurantObject implements Serializable {

	private String name;
	private String description;
	private String id;

	public RestaurantObject(String name, String description, String id) {
		super();
		this.name = name;
		this.description = description;
		this.id = id;
	}

	public String getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

