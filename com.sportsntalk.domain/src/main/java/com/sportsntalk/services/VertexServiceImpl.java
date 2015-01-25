package com.sportsntalk.services;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sportsntalk.data.BaseDao;
import com.sportsntalk.entities.Vertex;

/**
 * Provides services for vertex data.
 */
@Service("vertexService")
public class VertexServiceImpl implements VertexService
{
	@Resource(name="vertexDao")
	private BaseDao<Vertex,Long> _dao;

	/**
	 * Default constructor.
	 */
	public VertexServiceImpl()
	{
	}

	/**
	 * Find the specified vertex.
	 *
	 * @param id - the id
	 */
	@Override
	@Transactional(readOnly = true)
	public Vertex find(Long id)
	{
		return _dao.find(id);
	}

	/**
	 * Update the specified vertex.
	 *
	 * @param vertex - the vertex
	 */
	@Override
	@Transactional
	public Vertex save(Vertex vertex)
	{
		Vertex existingVertex = find(vertex.getId());
		existingVertex.setId(vertex.getId());
		existingVertex.setVertexTypeId(vertex.getVertexTypeId());
		existingVertex.setCreatedOn(vertex.getCreatedOn());
		existingVertex.setCreatedBy(vertex.getCreatedBy());
		existingVertex.setModifiedOn(vertex.getModifiedOn());
		existingVertex.setModifiedBy(vertex.getModifiedBy());
		return _dao.save(existingVertex);
	}
}
