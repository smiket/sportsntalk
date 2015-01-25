package com.sportsntalk.data;

import java.io.Serializable;
import java.util.List;

/**
 * Interface for dao classes.
 *
 * @param <T> The entity type
 * @param <ID> The identifier type
 */
public interface BaseDao<T, ID extends Serializable>
{

	/**
	 * Find a single entity.
	 *
	 * @param id - the id
	 * @return the entity
	 */
	public abstract T find(ID id);

	/**
	 * Find the specified entities.
	 *
	 * @param ids - the list of ids
	 * @return the list of entities
	 */
	public abstract List<T> find(Iterable<ID> ids);

	/**
	 * Find all entities.
	 *
	 * @return the list of entities
	 */
	public abstract List<T> findAll();

	/**
	 * Save the specified entity.
	 *
	 * @param entity - the entity
	 * @return the saved entity
	 */
	public abstract T save(T entity);

	/**
	 * Save the specified entity.
	 *
	 * @param entities - the entities
	 * @return the saved entity
	 */
	public abstract List<T> saveAll(Iterable<T> entities);

	/**
	 * Delete a single entity.
	 *
	 * @param id - the id
	 */
	public abstract void delete(ID id);

	/**
	 * Delete the specified entities.
	 *
	 * @param entities - the entities
	 */
	public abstract void delete(Iterable<T> entities);

	/**
	 * Delete all entities.
	 */
	public abstract void deleteAll();

}
