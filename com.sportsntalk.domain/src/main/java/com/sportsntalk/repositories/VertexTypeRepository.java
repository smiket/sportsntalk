package com.sportsntalk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportsntalk.entities.VertexType;

/**
 * Defines behavior for a vertex type repository.
 */
public interface VertexTypeRepository extends JpaRepository<VertexType, Long>
{

}
