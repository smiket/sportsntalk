package com.sportsntalk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportsntalk.entities.Edge;

/**
 * Defines behavior for an edge repository.
 */
public interface EdgeRepository extends JpaRepository<Edge, Long>
{

}
