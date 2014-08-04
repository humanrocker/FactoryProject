package com.factoryproject.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.factoryproject.data.User;

/**
 * The DAO of User object
 * 
 * @author TonyHong
 */
public class UserHibernateDAO extends GenericHibernateDAO<User, Integer> {

	/**
	 * Constructor function <br />
	 * Begin a new transaction automatically <br />
	 */
	public UserHibernateDAO() {
		beginTransaction();
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
	 * Find all User objects <br />
	 * 
	 * @return a list of all User objects
	 */
	public List<User> getAllUsers() {
		return findAll();
	}

	/**
	 * Fail at test! -- 19.06.14 by Tony Hong <br />
	 * 
	 * Find a User object by its index <br />
	 * 
	 * @param userID
	 * @return an object of index: UserID
	 */
	public User findUserByID(Integer userID) {
		return findById(userID, false);
	}

	/**
	 * Find a User object by its username <br />
	 * 
	 * Not tested! ID is managed by DB
	 * 
	 * @param name
	 * @return an object of username
	 */
	public User findUserByName(String username) {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		return (User) criteria.uniqueResult();
	}

	/**
	 * Set the password for a User object. <br />
	 * Find the user by its username and then set the password for it. <br />
	 * 
	 * @param username
	 * @param password
	 */
	public void setPasswordByUsername(String username, String password) {
		User user = findUserByName(username);
		makeTransient(user);
		user.setPassword(password);
		makePersistent(user);
	}

	/**
	 * Set the permission for a User object. <br />
	 * Find the user by its username and then set the permission for it. <br />
	 * 
	 * @param username
	 * @param permission
	 */
	public void setPermissionByUsername(String username, int permission) {
		User user = findUserByName(username);
		makeTransient(user);
		user.setPermission(permission);
		makePersistent(user);
	}

	/**
	 * Get the password for a User object. <br />
	 * Find the user by its username and then get the password for it. <br />
	 * 
	 * @param username
	 * @retuen password
	 */
	public String getPasswordByUsername(String username) {
		return findUserByName(username).getPassword();
	}

	/**
	 * Get the permission for a User object. <br />
	 * Find the user by its username and then get the permission for it. <br />
	 * 
	 * @param username
	 * @retuen permission
	 */
	public int getPermissionByUsername(String username) {
		return findUserByName(username).getPermission();
	}

	/**
	 * Find all User objects which have the same permission <br />
	 * 
	 * @param permission
	 * @return a list of all User objects
	 */
	@SuppressWarnings("unchecked")
	public List<User> findUsersByPermission(int permission) {
		Criteria criteria = getSession().createCriteria(User.class);
		List<User> result = criteria.add(
				Restrictions.eq("permission", permission)).list();
		return result;
	}
}
