package com.priya.database.databasedemo.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.priya.database.databasedemo.entity.Person;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.priya.database.databasedemo.entity.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class PersonJdbcDAO {
	//select * from person
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class PersonRowMapper implements RowMapper<Person>{

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthDate(rs.getTimestamp("birth_date"));
			
			return person;
		}
		
	}
	/*
	public List<Person> findAll(){
		return jdbcTemplate.query("select * from personjpa", new PersonRowMapper());		
	}
	*/
	
	//select
//	public List<Person> findAll(){
//		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));		
//	}
	
	
	//select by particular id
	public Person findById(int id){
		return jdbcTemplate.queryForObject("select * from personjpa where id=? ",new Object[] {id}, new BeanPropertyRowMapper<Person>(Person.class));		
	}
//	//delete
//	public int deleteById(int id){
//		return jdbcTemplate.update("delete from personjpa where id=? ", new Object[] {id});		
//	}
//	//insert
//	public int insert(Person person){
//		return jdbcTemplate.update("insert into personjpa(id, name, location, birth_date) values (?,?,?,?)", new Object[] {person.getId(),person.getName(),person.getLocation(),new Timestamp(person.getBirthDate().getTime())});		
//	}
//	
//	public int update(Person person){
//		return jdbcTemplate.update("update personjpa set name=?, location =?, birth_date =? where id =?", new Object[] {person.getName(),person.getLocation(),new Timestamp(person.getBirthDate().getTime()),person.getId()});		
//	}

}
