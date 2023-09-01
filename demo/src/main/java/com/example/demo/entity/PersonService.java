package com.example.demo.entity;

import java.util.List;

import com.example.demo.exception.IdNotFoundException;
import com.example.demo.exception.InvalidNameFormatException;

public interface PersonService {
	Person addPerson(Person person) throws InvalidNameFormatException;
	
	void deletePerson(int id) throws IdNotFoundException;
	
	Person updatePersonName(int id ,String name) throws InvalidNameFormatException,IdNotFoundException;
	
	List<Person> getPersons();

}
