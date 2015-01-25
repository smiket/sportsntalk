package com.sportsntalk.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sportsntalk.entities.Edge;
import com.sportsntalk.repositories.EdgeRepository;

/**
 * Data access for edge entities.
 */
@Repository("edgeDao")
public class EdgeDaoImpl extends BaseDaoImpl<Edge, Long>
{
	/**
	 * Default constructor.
	 *
	 * @param repository - the repository
	 */
	@Autowired
	public EdgeDaoImpl(EdgeRepository repository)
	{
		super(repository);
	}
}
