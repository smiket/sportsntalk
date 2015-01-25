package com.sportsntalk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportsntalk.entities.Vertex;

/**
 * Defines behavior for a vertex repository.
 */
public interface VertexRepository extends JpaRepository<Vertex, Long>
{

}
