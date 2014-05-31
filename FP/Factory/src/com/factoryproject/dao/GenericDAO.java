package com.factoryproject.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Generic interface of all DAOs <br \>
 * 所有DAO的接口
 * 
 * @author TonyHong
 * 
 * @param <T>
 *            Type of instance <br \>
 *            存储对象的类型
 * @param <ID>
 *            Type of index <br \>
 *            对象索引的类型
 */
public interface GenericDAO<T, ID extends Serializable> {
	/**
	 * Find specific object by its index <br />
	 * 通过对象的索引来寻找对象
	 * 
	 * @param id
	 *            Index of target object <br />
	 *            需要寻找的对象的索引值
	 * @param lock
	 *            Does it need a lock? <br />
	 *            是否需要加锁
	 * @return The reference to the target objecte <br />
	 *         返回索引所对应对象的引用
	 */
	T findById(ID id, boolean lock);

	/**
	 * Find all objects <br />
	 * 
	 * @return The reference to the List of all objects <br />
	 */
	List<T> findAll();

	/**
	 * Find specific object/objects by an example <br />
	 * 
	 * @param exampleInstance
	 *            An example of target object/objects <br />
	 * @param excludeProperty
	 *            A list of String containing properties of exclusion <br />
	 * @return The reference to the List of all object/objects which comes from
	 *         the query by the example <br />
	 */
	List<T> findByExample(T exampleInstance, String... excludeProperty);

	/**
	 * Make the specific entity persistent <br />
	 * 
	 * @param entity
	 *            An entity need to be persisted <br />
	 * @return The reference to the entity <br />
	 */
	T makePersistent(T entity);

	/**
	 * Make the specific entity persistent <br />
	 * 
	 * @param entity
	 *            An entity need to be persisted <br />
	 * @return The reference to the entity <br />
	 */
	void makeTransient(T entity);

	/**
	 * Flush the session <br />
	 */
	void flush();

	/**
	 * Clean the session <br />
	 */
	void clear();
}
