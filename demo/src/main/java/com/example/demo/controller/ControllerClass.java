package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Person;
import com.example.demo.entity.PersonService;
import com.example.demo.exception.IdNotFoundException;
import com.example.demo.exception.InvalidNameFormatException;

@RestController
public class ControllerClass {

	@Autowired
	private PersonService personService;

	@PostMapping("/addPerson")
	public Person addPerson(Person person) throws InvalidNameFormatException {
		return personService.addPerson(person);
	}

	@DeleteMapping("/deletePeron/{id}")
	public String deletePerson(@PathVariable("id") int id) throws IdNotFoundException {
		personService.deletePerson(id);
		return id+" data deleted";
	}

	@PutMapping("/updateName/{id}")
	public Person updatePersonName(@PathVariable("id")int  id,@RequestParam("name") String name) throws InvalidNameFormatException,IdNotFoundException {
		return personService.updatePersonName(id, name);
	}

	@GetMapping("/persons")
	public List<Person> getPersons() {
		return personService.getPersons();
	}
}
