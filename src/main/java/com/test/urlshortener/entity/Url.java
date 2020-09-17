package com.test.urlshortener.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Url {
	@Id
	@GeneratedValue
	private int id;
	private String urlComplete;
	private String urlRaccourcie;

	public Url() {
	}

	public Url(String urlComplete) {
		super();
		this.urlComplete = urlComplete;
	}

	public Url(int id, String urlComplete, String urlRaccourcie) {
		super();
		this.id = id;
		this.urlComplete = urlComplete;
		this.urlRaccourcie = urlRaccourcie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrlComplete() {
		return urlComplete;
	}

	public void setUrlComplete(String urlComplete) {
		this.urlComplete = urlComplete;
	}

	public String getUrlRaccourcie() {
		return urlRaccourcie;
	}

	public void setUrlRaccourcie(String urlRaccourcie) {
		this.urlRaccourcie = urlRaccourcie;
	}

}
