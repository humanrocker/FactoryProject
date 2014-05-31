package com.factoryproject.dao;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Transaction;

import com.factoryproject.data.User;

/**
 * The DAO of User object
 * 
 * @author TonyHong
 */
public class UserHibernateDAO extends GenericHibernateDAO<User, Integer> {
	private static Session currentSession;
	private Transaction tx;

	/**
	 * Constructor function <br />
	 * Begin a new transaction automatically <br />
	 */
	public UserHibernateDAO() {
		openSession();
		beginTransaction();
	}

	/**
	 * Deconstructor function <br />
	 * Must be called after using the object!!! <br />
	 * 一定要在使用完DAO对象后调用！！！
	 */
	public void destory() {
		commitTransaction();
		closeSession();
	}

	/**
	 * Open a new hibernate session by calling getSession() in <br />
	 * <code> com.factoryproject.HibernateSessionFactory </code>
	 * 
	 * @see com.factoryproject.HibernateSessionFactory
	 */
	protected void openSession() {
		currentSession = getSession();
		if (currentSession != null)
			setSession(currentSession);
	}

	/**
	 * Close the single hibernate session instance by calling closeSession() in <br />
	 * <code> com.factoryproject.HibernateSessionFactory </code>
	 * 
	 * @see com.factoryproject.HibernateSessionFactory
	 */
	protected void closeSession() {
		close();
	}

	/**
	 * Begin a new transaction by calling beginTransaction() in <br />
	 * <code>  org.hibernate.Session </code>
	 * 
	 * @see org.hibernate.Transaction
	 */
	protected void beginTransaction() {
		if (currentSession != null)
			tx = currentSession.beginTransaction();
	}

	/**
	 * Commit the current transaction by calling commit() in <br />
	 * <code> org.hibernate.Session </code>
	 * 
	 * @see org.hibernate.Transaction
	 */
	protected void commitTransaction() {
		if (tx != null)
			tx.commit();
	}
	
	/**
	 * Persist a User object <br />
	 * 
	 * @param user
	 * @return
	 */
	public User addUser(User user) {
		makePersistent(user);
		return user;
	}

	/**
	 * Delete a specific User object <br />
	 * 
	 * @param user
	 * @return
	 */
	public User deleteUser(User user) {
		makeTransient(user);
		return user;
	}

	/**
	 * Find all Message objects <br />
	 * 
	 * @return a list of all Message objects
	 */
	public List<User> getAllUsers() {
		return findAll();
	}

	/**
	 * Find a Message object by its index <br />
	 * 
	 * @param userID
	 * @return an object of index MessageID
	 */
	public User findUserByID(Integer userID) {
		return findById(userID, false);
	}
	
	public void setPasswordByUsername(String username, String password) {
		User user = findUserByName(username);
		makeTransient(user);
		user.setPassword(password);
		makePersistent(user);
	} 

	public void setPermissionByUsername(String username, int permission) {
		User user = findUserByName(username);
		makeTransient(user);
		user.setPermission(permission);
		makePersistent(user);
	}

	public String getPasswordByUsername(String username) {
		return findUserByName(username).getPassword();
	}

	public int getPermissionByUsername(String username) {
		return findUserByName(username).getPermission();
	}


	public User findUserByName(String name) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", name));
		return (User) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<User> findUsersByPermission(int permission) {
		Criteria criteria = getSession().createCriteria(User.class);
		List<User> result = criteria.add(
				Restrictions.eq("permission", permission)).list();
		return result;
	}
}
