package com.factoryproject.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.factoryproject.dao.GenericHibernateDAO;
import com.factoryproject.data.News;
import com.factoryproject.data.User;

/**
 * The DAO of News object
 * 
 * @author TonyHong
 */
public class NewsHibernateDAO extends GenericHibernateDAO<News, Integer> {

	/**
	 * Constructor function <br />
	 * Begin a new transaction automatically <br />
	 */
	public NewsHibernateDAO() {
		beginTransaction();
	}

	/**
	 * Persist a News object <br />
	 * 持久化
	 * @param News
	 * @return	The object itself.
	 */
	public News addNews(News news) {
		makePersistent(news);
		return news;
	}

	/**
	 * Delete a specific News object <br />
	 * 
	 * @param News
	 * @return
	 */
	public News deleteNews(News news) {
		makeTransient(news);
		return news;
	}

	/**
	 * Find all News objects <br />
	 * 
	 * @return a list of all News objects
	 */
	public List<News> getAllNews() {
		return findAll();
	}

	/**
	 * Find a News object by its index <br />
	 * 
	 * @param newsID
	 * @return an object of index NewsID
	 */
	public News findNewsByID(Integer newsID) {
		return findById(newsID, false);
	}

	/**
	 * Find the content of the News object by its index <br />
	 * 
	 * @param newsID
	 * @return The content of the object of index NewsID
	 */
	public String getContentByID(Integer newsID) {
		return findNewsByID(newsID).getContent();
	}

	/**
	 * Find the added date of the News object by its index <br />
	 * 
	 * @param newsID
	 * @return The added date of the object of index NewsID
	 */
	public Date getCreatedDateByID(Integer newsID) {
		return findNewsByID(newsID).getCreatedDate();
	}

	/**
	 * Find the speaker of the News object by its index <br />
	 * 
	 * @param newsID
	 * @return The added date of the object of index NewsID
	 */
	public User getSpeakerByID(Integer newsID) {
		return findNewsByID(newsID).getSpeaker();
	}

	/**
	 * Find the newss of the News object by specfic content <br />
	 * 
	 * @param content
	 * @return The added date of the object of index NewsID
	 */
	public News findNewsByContent(String content) {
		Criteria criteria = getSession().createCriteria(News.class);
		criteria.add(Restrictions.eq("content", content.trim()));
		return (News) criteria.uniqueResult();
	}

	/**
	 * Find the newss of the News object by specfic speaker <br />
	 * 
	 * @param speaker
	 * @return The added date of the object of index NewsID
	 */
	@SuppressWarnings("unchecked")
	public List<News> findNewsBySpeaker(User speaker) {
		Criteria criteria = getSession().createCriteria(News.class);
		List<News> result = criteria
				.add(Restrictions.eq("speaker", speaker)).list();
		return result;
	}

	/**
	 * Find the newss of the News object by specfic added date <br />
	 * 
	 * @param addedDate
	 * @return The added date of the object of index NewsID
	 */
	@SuppressWarnings("unchecked")
	public List<News> findNewsByDateAdded(Date addedDate) {
		Criteria criteria = getSession().createCriteria(News.class);
		List<News> result = criteria.add(
				Restrictions.eq("dateAdded", addedDate)).list();
		return result;
	}
}
