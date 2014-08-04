package com.factoryproject.data;

// Generated 2014-6-18 21:15:10 by Hibernate Tools 3.2.0.b9

import java.util.Date;

/**
 * Represents a piece of news in the database.
 * 
 * @author Tony Hong (with help from Hibernate)
 */
public class News implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	/**
	 * Content of the news.
	 */
	private String content;
	/**
	 * News by this user
	 */
	private User publisher;
	/**
	 * When the message was created
	 */
	private Date createdDate;
	/**
	 * When the message was modifiedDate
	 */
	private Date modifiedDate;

	public News() {
	}

	public News(String content, User publisher) {
		this.content = content;
		this.publisher = publisher;
	}

	public News(String content, User publisher, Date createdDate,
			Date modifiedDate) {
		this.content = content;
		this.publisher = publisher;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}

	public int getId() {
		return this.id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	/**
	 * * Content of the news.
	 */
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * * News by this user
	 */
	public User getPublisher() {
		return this.publisher;
	}

	public void setPublisher(User publisher) {
		this.publisher = publisher;
	}

	/**
	 * * When the message was created
	 */
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * * When the message was modifiedDate
	 */
	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
