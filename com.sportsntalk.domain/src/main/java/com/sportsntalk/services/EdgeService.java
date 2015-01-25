package com.sportsntalk.services;

import com.sportsntalk.entities.Edge;

/**
 * Provides services for edge data.
 */
public interface EdgeService
{
	/**
	 * Find the specified edge.
	 *
	 * @param id - the id
	 * @return the edge
	 */
	public Edge find(Long id);

	/**
	 * Save the specified edge.
	 *
	 * @param edge - the edge
	 * @return the edge
	 */
	public Edge save(Edge edge);
}
