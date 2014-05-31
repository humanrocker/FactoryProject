package com.factoryproject.data;

// Generated 2014-4-8 20:35:51 by Hibernate Tools 3.2.0.b9

import java.util.Date;

/**
 * Represents a single playable track in the music database. @author Jim Elliott
 * (with help from Hibernate)
 */
public class Message implements java.io.Serializable {

	private int id;

	private String content;
	/**
	 * When the message was created
	 */
	private Date createdDate;
	/**
	 * Messages by this user
	 */
	private User speaker;
	/**
	 * The Messages replied to
	 */
	private Message replyingMessageID;

	public Message() {
	}

	public Message(String content, User speaker) {
		this.content = content;
		this.speaker = speaker;
	}

	public Message(String content, Date dateAdded, User speaker,
			Message replyingMessageID) {
		this.content = content;
		this.setCreatedDate(dateAdded);
		this.speaker = speaker;
		this.replyingMessageID = replyingMessageID;
	}

	public int getId() {
		return this.id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
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
	 * * Messages by this user
	 */
	public User getSpeaker() {
		return this.speaker;
	}

	public void setSpeaker(User speaker) {
		this.speaker = speaker;
	}

	/**
	 * * the Messages replied to
	 */
	public Message getReplyingMessageID() {
		return this.replyingMessageID;
	}

	public void setReplyingMessageID(Message replyingMessageID) {
		this.replyingMessageID = replyingMessageID;
	}

}
