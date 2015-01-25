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
@Table(name = "edge")
public class Edge
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long _id;

	@Column(name = "edge_type_id")
	private Long _edgeTypeId;

	@Column(name = "start_vertex_id")
	private Long _startVertexId;

	@Column(name = "end_vertex_id")
	private Long _endVertexId;

	@Column(name = "valid_from")
	private Date _validFrom;

	@Column(name = "valid_to")
	private Date _validTo;

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
	public Edge()
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
	 * Get the edge type id.
	 *
	 * @return the value
	 */
	public Long getEdgeTypeId()
	{
		return _edgeTypeId;
	}

	/**
	 * Set the edge type id.
	 *
	 * @param value - the value to set
	 */
	public void setEdgeTypeId(Long value)
	{
		_edgeTypeId = value;
	}

	/**
	 * Get the start vertex id.
	 *
	 * @return the value
	 */
	public Long getStartVertexId()
	{
		return _startVertexId;
	}

	/**
	 * Set the start vertex id.
	 *
	 * @param value - the value to set
	 */
	public void setStartVertexId(Long value)
	{
		_startVertexId = value;
	}

	/**
	 * Get the end vertex id.
	 *
	 * @return the value
	 */
	public Long getEndVertexId()
	{
		return _endVertexId;
	}

	/**
	 * Set the end vertex id.
	 *
	 * @param value - the value to set
	 */
	public void setEndVertexId(Long value)
	{
		_endVertexId = value;
	}

	/**
	 * Get valid from date.
	 *
	 * @return the value
	 */
	public Date getValidFrom()
	{
		return _validFrom;
	}

	/**
	 * Set the valid from date.
	 *
	 * @param value - the value to set
	 */
	public void setValidFrom(Date value)
	{
		_validFrom = value;
	}

	/**
	 * Get valid to date.
	 *
	 * @return the value
	 */
	public Date getValidTo()
	{
		return _validTo;
	}

	/**
	 * Set the valid from date.
	 *
	 * @param value - the value to set
	 */
	public void setValidTo(Date value)
	{
		_validTo = value;
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
