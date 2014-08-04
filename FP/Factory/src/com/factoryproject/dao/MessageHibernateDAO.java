package com.factoryproject.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.factoryproject.dao.GenericHibernateDAO;
import com.factoryproject.data.Message;
import com.factoryproject.data.User;

/**
 * The DAO of Message object
 * 
 * @author TonyHong
 */
public class MessageHibernateDAO extends GenericHibernateDAO<Message, Integer> {

	/**
	 * Constructor function <br />
	 * Begin a new transaction automatically <br />
	 */
	public MessageHibernateDAO() {
		beginTransaction();
	}

	/**
	 * Persist a Message object <br />
	 * 
	 * @param Message
	 * @return
	 */
	public Message addMessage(Message message) {
		makePersistent(message);
		return message;
	}

	/**
	 * Delete a specific Message object <br />
	 * 
	 * @param Message
	 * @return
	 */
	public Message deleteMessage(Message message) {
		makeTransient(message);
		return message;
	}

	/**
	 * Find all Message objects <br />
	 * 
	 * @return a list of all Message objects
	 */
	public List<Message> getAllMessages() {
		return findAll();
	}

	/**
	 * Find a Message object by its index <br />
	 * 
	 * @param messageID
	 * @return an object of index MessageID
	 */
	public Message findMessageByID(Integer messageID) {
		return findById(messageID, false);
	}

	/**
	 * Find the content of the Message object by its index <br />
	 * 
	 * @param messageID
	 * @return The content of the object of index MessageID
	 */
	public String getContentByID(Integer messageID) {
		return findMessageByID(messageID).getContent();
	}

	/**
	 * Find the added date of the Message object by its index <br />
	 * 
	 * @param messageID
	 * @return The added date of the object of index MessageID
	 */
	public Date getCreatedDateByID(Integer messageID) {
		return findMessageByID(messageID).getCreatedDate();
	}

	/**
	 * Find the speaker of the Message object by its index <br />
	 * 
	 * @param messageID
	 * @return The added date of the object of index MessageID
	 */
	public User getSpeakerByID(Integer messageID) {
		return findMessageByID(messageID).getSpeaker();
	}

	/**
	 * Find the replying message ID of the Message object by its index <br />
	 * 
	 * @param messageID
	 * @return The added date of the object of index MessageID
	 */
	public Message getReplyingMessageByID(Integer messageID) {
		return findMessageByID(messageID).getReplyingMessage();
	}

	/**
	 * Find the messages of the Message object by specfic content <br />
	 * 
	 * @param content
	 * @return The added date of the object of index MessageID
	 */
	public Message findMessageByContent(String content) {
		Criteria criteria = getSession().createCriteria(Message.class);
		criteria.add(Restrictions.eq("content", content.trim()));
		return (Message) criteria.uniqueResult();
	}

	/**
	 * Find the messages of the Message object by specfic speaker <br />
	 * 
	 * @param speaker
	 * @return The added date of the object of index MessageID
	 */
	@SuppressWarnings("unchecked")
	public List<Message> findMessagesBySpeaker(User speaker) {
		Criteria criteria = getSession().createCriteria(Message.class);
		List<Message> result = criteria
				.add(Restrictions.eq("speaker", speaker)).list();
		return result;
	}

	/**
	 * Find the messages of the Message object by specfic added date <br />
	 * 
	 * @param addedDate
	 * @return The added date of the object of index MessageID
	 */
	@SuppressWarnings("unchecked")
	public List<Message> findMessagesByDateAdded(Date addedDate) {
		Criteria criteria = getSession().createCriteria(Message.class);
		List<Message> result = criteria.add(
				Restrictions.eq("dateAdded", addedDate)).list();
		return result;
	}

	/**
	 * Find the messages of the Message object by specfic speaker <br />
	 * 
	 * @param replyingMessageID
	 * @return The replyingMessageID of the object of index MessageID
	 */
	@SuppressWarnings("unchecked")
	public List<Message> findMessagesByReplyingMessageID(
			Message replyingMessageID) {
		Criteria criteria = getSession().createCriteria(Message.class);
		List<Message> result = criteria.add(
				Restrictions.eq("replyingMessageID", replyingMessageID)).list();
		return result;
	}
}
