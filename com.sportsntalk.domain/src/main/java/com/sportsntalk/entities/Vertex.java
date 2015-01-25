package com.sportsntalk.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a vertex in the social graph.
 */
@Entity
@Table(name = "vertex")
public class Vertex
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long _id;

	@Column(name = "vertex_type_id")
	private Long _vertexTypeId;

	@Column(name = "created_on")
	private Date _createdOn;

	@Column(name = "created_by")
	private String _createdBy;

	@Column(name = "modified_on")
	private Date _modifiedOn;

	@Column(name = "modified_by")
	private String _modifiedBy;

	/**
	 * Default constructor.
	 */
	public Vertex()
	{
		super();
	}

	/**
	 * Get the id.
	 *
	 * @return the value
	 */
	public Long getId()
	{
		return _id;
	}

	/**
	 * Set the id.
	 *
	 * @param value - the value to set
	 */
	public void setId(Long value)
	{
		_id = value;
	}

	/**
	 * Get the vertex type id.
	 *
	 * @return the value
	 */
	public Long getVertexTypeId()
	{
		return _vertexTypeId;
	}

	/**
	 * Set the vertex type id.
	 *
	 * @param value - the value to set
	 */
	public void setVertexTypeId(Long value)
	{
		_vertexTypeId = value;
	}

	/**
	 * Get the creation date.
	 *
	 * @return the value
	 */
	public Date getCreatedOn()
	{
		return _createdOn;
	}

	/**
	 * Set the creation date.
	 *
	 * @param value - the value to set
	 */
	public void setCreatedOn(Date value)
	{
		_createdOn = value;
	}

	/**
	 * Get the creator.
	 *
	 * @return the value
	 */
	public String getCreatedBy()
	{
		return _createdBy;
	}

	/**
	 * Set the creator.
	 *
	 * @param value - the value to set
	 */
	public void setCreatedBy(String value)
	{
		_createdBy = value;
	}

	/**
	 * Get the mutation date.
	 *
	 * @return the value
	 */
	public Date getModifiedOn()
	{
		return _modifiedOn;
	}

	/**
	 * Set the mutation date.
	 *
	 * @param value - the value to set
	 */
	public void setModifiedOn(Date value)
	{
		_modifiedOn = value;
	}

	/**
	 * Get the last mutator.
	 *
	 * @return the value
	 */
	public String getModifiedBy()
	{
		return _modifiedBy;
	}

	/**
	 * Set the last mutator.
	 *
	 * @param value - the value to set
	 */
	public void setModifiedBy(String value)
	{
		_modifiedBy = value;
	}
}
