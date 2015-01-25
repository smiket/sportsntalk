package com.sportsntalk.data;

import java.io.Serializable;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 * Base class for DAO types.
 *
 * @param <T> The entity type
 * @param <ID> The identifier type
 */
public class BaseDaoImpl<T, ID extends Serializable> extends NamedParameterJdbcDaoSupport implements BaseDao<T, ID>
{
	private final JpaRepository<T, ID> _repository;

	/**
	 * Default constructor.
	 *
	 * @param repository - the repository
	 */
	public BaseDaoImpl(JpaRepository<T, ID> repository)
	{
		_repository = repository;
	}

	/**
	 * Configure the datasource.
	 *
	 * @param dataSource
	 */
	@Autowired
	public void setConfigureDataSource(DataSource dataSource) {
		setDataSource(dataSource);
	}

	/* (non-Javadoc)
	 * @see com.sportsntalk.data.BaseDao#find(ID)
	 */
	@Override
	@Transactional(readOnly = true)
	public T find(ID id)
	{
		return _repository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see com.sportsntalk.data.BaseDao#find(java.lang.Iterable)
	 */
	@Override
	@Transactional(readOnly = true)
	public List<T> find(Iterable<ID> ids)
	{
		return _repository.findAll(ids);
	}

	/* (non-Javadoc)
	 * @see com.sportsntalk.data.BaseDao#findAll()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<T> findAll()
	{
		return _repository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.sportsntalk.data.BaseDao#save(T)
	 */
	@Override
	@Transactional
	public T save(T entity)
	{
		return _repository.save(entity);
	}

	/* (non-Javadoc)
	 * @see com.sportsntalk.data.BaseDao#saveAll(java.lang.Iterable)
	 */
	@Override
	@Transactional
	public List<T> saveAll(Iterable<T> entities)
	{
		return _repository.save(entities);
	}

	/* (non-Javadoc)
	 * @see com.sportsntalk.data.BaseDao#delete(ID)
	 */
	@Override
	@Transactional
	public void delete(ID id)
	{
		_repository.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.sportsntalk.data.BaseDao#delete(java.lang.Iterable)
	 */
	@Override
	@Transactional
	public void delete(Iterable<T> entities)
	{
		_repository.delete(entities);
	}

	/* (non-Javadoc)
	 * @see com.sportsntalk.data.BaseDao#deleteAll()
	 */
	@Override
	@Transactional
	public void deleteAll()
	{
		_repository.deleteAll();
	}
}
