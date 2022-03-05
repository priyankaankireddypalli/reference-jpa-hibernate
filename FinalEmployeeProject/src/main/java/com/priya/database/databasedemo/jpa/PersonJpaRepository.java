package com.priya.database.databasedemo.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.priya.database.databasedemo.entity.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

//Repository
//Transaction
@Repository
@Transactional
public class PersonJpaRepository {
	
	//connect to database 
	@PersistenceContext
	EntityManager entityManager;
	
	
	//method to retrieve data
	//select
	public List<Person> findAll(){
		 TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons",Person.class);
		 return namedQuery.getResultList();
	}
	//select by particular id
		public Person findById(int id){
			return entityManager.find(Person.class, id);
					//jdbcTemplate.queryForObject("select * from personjpa where id=? ",new Object[] {id}, new BeanPropertyRowMapper<Person>(Person.class));		
		}
		
		public Person update(Person person) {
			return entityManager.merge(person);
		}
		
		public Person insert(Person person) {
			return entityManager.merge(person);
		}
		
		public void deleteById(int id) {
			Person person = findById(id);
			entityManager.remove(person);
		}
		
	
}
