package com.sportsntalk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportsntalk.entities.Edge;

/**
 * Defines behavior for an edge type repository.
 */
public interface EdgeTypeRepository extends JpaRepository<Edge, Long>
{

}
