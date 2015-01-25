package com.sportsntalk.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents an edge type (post, like, share, comment etc).
 */
@Entity
@Table(name = "edge_type")
public class EdgeType
{
	@Id
	@Column(name = "id")
	private int _id;

	@Column(name = "name")
	private String _name;

	/**
	 * Default constructor.
	 */
	public EdgeType()
	{
		super();
	}

	/**
	 * Get the id.
	 *
	 * @return the value
	 */
	public int getId()
	{
		return _id;
	}

	/**
	 * Set the id.
	 *
	 * @param value the value to set
	 */
	public void setId(int value)
	{
		_id = value;
	}

	/**
	 * Get the name.
	 *
	 * @return the value
	 */
	public String getName()
	{
		return _name;
	}

	/**
	 * Set the name.
	 *
	 * @param value the value to set
	 */
	public void setName(String value)
	{
		_name = value;
	}
}
