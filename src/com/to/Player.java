package com.to;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Player {
	private String id;
	private String name;
	private Date dob;
	private String tdob;
	private String emai;
	private String gender;
	private String teamname;
	private long  contact;
	//hello
	
public Player() {
	// TODO Auto-generated constructor stub
}


public Player(String name, Date dob, String emai, String gender, String teamname, long contact) {
	super();
	this.name = name;
	this.dob = dob;
	this.emai = emai;
	this.gender = gender;
	this.teamname = teamname;
	this.contact = contact;
}


public Player(String id, String name, Date dob, String emai, String gender, String teamname, long contact) {
	super();
	this.id = id;
	this.name = name;
	this.dob = dob;
	this.emai = emai;
	this.gender = gender;
	this.teamname = teamname;
	this.contact = contact;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Date getDob() {
	return dob;
}

public void setDob(Date dob) {
	this.dob = dob;
}

public String getEmai() {
	return emai;
}

public void setEmai(String emai) {
	this.emai = emai;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getTeamname() {
	return teamname;
}

public void setTeamname(String teamname) {
	this.teamname = teamname;
}

public long getContact() {
	return contact;
}

public void setContact(long contact) {
	this.contact = contact;
}

@Override
public String toString() {
	return "Player [id=" + id + ", name=" + name + ", dob=" + dob + ", emai=" + emai + ", gender=" + gender
			+ ", teamname=" + teamname + ", contact=" + contact + "]";
}


public String getTdob() {
	return tdob;
}


public void setTdob(String tdob) {
	try {
		this.dob=new SimpleDateFormat("yyyy-MM-dd").parse(tdob);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
