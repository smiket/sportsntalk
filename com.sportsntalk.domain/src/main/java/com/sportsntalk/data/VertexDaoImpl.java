package com.sportsntalk.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sportsntalk.entities.Vertex;
import com.sportsntalk.repositories.VertexRepository;

/**
 * Data access for vertex entities.
 */
@Repository("vertexDao")
public class VertexDaoImpl extends BaseDaoImpl<Vertex, Long>
{
	/**
	 * Default constructor.
	 *
	 * @param repository - the repository
	 */
	@Autowired
	public VertexDaoImpl(VertexRepository repository)
	{
		super(repository);
	}
}
