package com.student;

import javax.xml.bind.annotation.XmlRootElement;

	@XmlRootElement(name = "User")
	public class User {
	  private String name;
	  private int id;
	
	  public String getName() {
	    return name;
	  }
	
	  public void setName(String name) {
	    this.name = name;
	  }
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

}