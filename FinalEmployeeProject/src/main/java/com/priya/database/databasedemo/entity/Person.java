package com.priya.database.databasedemo.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name="personjpa")
@NamedQuery(name="find_all_persons",query="select p from Person p")
public class Person {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String location;
	@Column(name="birth_date")
	private Timestamp birthDate;
	
	
	public Person() {
		
		
	}
	public Person(int id, String name, String location, Timestamp birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getLocation() {
		return location;
	}
	public Timestamp getBirthDate() {
		return birthDate;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setBirthDate(Timestamp timestamp) {
		this.birthDate = timestamp;
	}
	@Override
	public String toString() {
		return "\nPerson [id=" + id + ", name=" + name + ", location=" + location + ", birthDate=" + birthDate + "]";
	}
	

}
