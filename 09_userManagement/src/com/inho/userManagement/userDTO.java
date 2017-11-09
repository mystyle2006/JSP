package com.inho.userManagement;

import java.sql.Timestamp;

public class userDTO {
	private String id;
	private String pw;
	private String name;
	private String adres;
	private String city;
	private String state;
	private Timestamp cdate;
	
//	public userDTO(String id, String pw, String name, String adres, String city, String state) {
//		super();
//		this.id = id;
//		this.pw = pw;
//		this.name = name;
//		this.adres = adres;
//		this.city = city;
//		this.state = state;
//	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Timestamp getcDate() {
		return cdate;
	}

	public void setcDate(Timestamp cdate) {
		this.cdate = cdate;
	}
	
	
}

