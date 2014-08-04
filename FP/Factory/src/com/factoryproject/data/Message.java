package com.factoryproject.data;

// Generated 2014-6-18 21:15:10 by Hibernate Tools 3.2.0.b9

import java.util.Date;

/**
 * Represents a message in the database.
 * 
 * @author Tony Hong (with help from Hibernate)
 */
public class Message implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	/**
	 * Content of the message.
	 */
	private String content;
	/**
	 * When the message was created.
	 */
	private Date dateAdded;
	/**
	 * Messages by this user.
	 */
	private User speaker;
	/**
	 * Message that this one replies to.
	 */
	private Message replyingMessage;

	public Message() {
	}

	public Message(String content, User speaker) {
		this.content = content;
		this.speaker = speaker;
	}

	public Message(String content, Date dateAdded, User speaker,
			Message replyingMessage) {
		this.content = content;
		this.dateAdded = dateAdded;
		this.speaker = speaker;
		this.replyingMessage = replyingMessage;
	}

	public int getId() {
		return this.id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	/**
	 * * Content of the message.
	 */
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * * When the message was created.
	 */
	public Date getDateAdded() {
		return this.dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	/**
	 * * Messages by this user.
	 */
	public User getSpeaker() {
		return this.speaker;
	}

	public void setSpeaker(User speaker) {
		this.speaker = speaker;
	}

	/**
	 * * Message that this one replies to.
	 */
	public Message getReplyingMessage() {
		return this.replyingMessage;
	}

	public void setReplyingMessage(Message replyingMessage) {
		this.replyingMessage = replyingMessage;
	}

	/**
	 * toString
	 * 
	 * @return String
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append(getClass().getName()).append("@")
				.append(Integer.toHexString(hashCode())).append(" [");
		buffer.append("replyingMessage").append("='")
				.append(getReplyingMessage()).append("' ");
		buffer.append("]");

		return buffer.toString();
	}

}
