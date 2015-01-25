package com.sportsntalk.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sportsntalk.data.AppConfig;
import com.sportsntalk.repositories.VertexRepository;
import com.sportsntalk.repositories.VertexTypeRepository;
import com.sportsntalk.services.VertexService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class VertexTest
{
	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	EntityManager entityManager;

	@Autowired
	DataSource dataSource;

	@Autowired
	private VertexService vertexService;

	/**
	 * Runs before each unit test.
	 *
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		System.out.println("Before test called ...");
	}

	/**
	 * Runs after each unit test.
	 *
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception
	{
		System.out.println("After test called ...");
	}

	/**
	 * Find and save a vertex.
	 */
	@Test
	public void testSaveInstance()
	{
		//
		// Create entity, persist, find via repository.
		//
		Vertex vertex = new Vertex();
		vertex.setVertexTypeId(1L);
		vertex.setCreatedOn(new Date());
		vertex.setCreatedBy("smiket");
		vertex.setModifiedOn(new Date());
		vertex.setModifiedBy("smiket");

		VertexRepository repository = applicationContext.getBean(VertexRepository.class);
		Vertex savedVertex = repository.save(vertex);

		entityManager.clear();
		Vertex foundVertex = repository.findOne(savedVertex.getId());
		Assert.assertNotNull(foundVertex);
		Assert.assertNotSame(foundVertex, savedVertex);

		//
		// Find via service
		//
		Vertex savedVertex2 = vertexService.save(foundVertex);
		Assert.assertNotNull(savedVertex2);
		Assert.assertNotSame(savedVertex, savedVertex2);

		//
		// Find via jdbc call
		//
		JdbcTemplate template = new JdbcTemplate(dataSource);
		Vertex mappedVertex = template.queryForObject("select * from vertex where id = ?", new Object[] { foundVertex.getId() }, new VertexMapper());
		Assert.assertNotNull(mappedVertex);
	}

	/**
	 * Save a vertex.
	 */
	@Test
	public void testStreamVertexTypes()
	{
		VertexTypeRepository repository = applicationContext.getBean(VertexTypeRepository.class);
		List<VertexType> entities = repository.findAll();

		List<String> entitiesIds = entities.stream()
				.filter(e -> e.getName() != null)
				.sorted(Comparator.comparing(item -> item.getName()))
				.map(item -> item.getName())
				.collect(Collectors.toList());

		entitiesIds.stream().forEach(System.out::println);
	}
}

/**
 * Map resultset to entity.
 *
 */
class VertexMapper implements RowMapper<Vertex>
{
	/*
	 * (non-Javadoc)
	 *
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public Vertex mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		Vertex vertex = new Vertex();
		vertex.setId(rs.getLong("id"));
		vertex.setVertexTypeId(rs.getLong("vertex_type_id"));
		vertex.setCreatedOn(rs.getDate("created_on"));
		vertex.setCreatedBy(rs.getString("created_by"));
		vertex.setModifiedOn(rs.getDate("modified_on"));
		vertex.setModifiedBy(rs.getString("modified_by"));
		return vertex;
	}
}
