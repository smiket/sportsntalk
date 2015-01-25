package com.sportsntalk.services;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sportsntalk.data.BaseDao;
import com.sportsntalk.entities.Edge;

/**
 * Provides services for edge data.
 */
@Service("edgeService")
public class EdgeServiceImpl implements EdgeService
{
	@Resource(name="edgeDao")
	private BaseDao<Edge,Long> _dao;

	/**
	 * Default constructor.
	 */
	public EdgeServiceImpl()
	{
	}

	/**
	 * Find the specified edge.
	 *
	 * @param id - the id
	 * @return the edge
	 */
	@Override
	@Transactional(readOnly = true)
	public Edge find(Long id)
	{
		return _dao.find(id);
	}

	/**
	 * Save the specified edge.
	 *
	 * @param edge - the edge
	 * @return the edge
	 */
	@Override
	@Transactional
	public Edge save(Edge edge)
	{
		Edge existingEdge = find(edge.getId());
		existingEdge.setId(edge.getId());
		existingEdge.setEdgeTypeId(edge.getEdgeTypeId());
		existingEdge.setStartVertexId(edge.getStartVertexId());
		existingEdge.setEndVertexId(edge.getEndVertexId());
		existingEdge.setValidFrom(edge.getValidFrom());
		existingEdge.setValidTo(edge.getValidTo());
		existingEdge.setCreatedOn(edge.getCreatedOn());
		existingEdge.setCreatedBy(edge.getCreatedBy());
		existingEdge.setModifiedOn(edge.getModifiedOn());
		existingEdge.setModifiedBy(edge.getModifiedBy());
		return _dao.save(existingEdge);
	}
}
