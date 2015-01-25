package com.sportsntalk.services;

import com.sportsntalk.entities.Vertex;

/**
 * Provides services for vertex data.
 */
public interface VertexService
{
	/**
	 * Find the specified vertex.
	 *
	 * @param id - the id
	 */
	public Vertex find(Long id);

	/**
	 * Update the specified vertex.
	 *
	 * @param vertex - the vertex
	 */
	public Vertex save(Vertex vertex);
}
