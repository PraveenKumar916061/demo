package com.example.demo.entity;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.exception.IdNotFoundException;
import com.example.demo.exception.InvalidNameFormatException;

@Service
public class PersonServiceImp implements PersonService {

	@Autowired
	private PersonDao dao;
	Pattern pattern = Pattern.compile("[A-Z][ ][a-z]*");
	@Override
	public Person addPerson(Person person) throws InvalidNameFormatException {
		

		Person person2 = new Person();
		Matcher matcher = pattern.matcher(person.getName());
		if (matcher.matches())
			person2.setName(person.getName());
		else 
			throw new InvalidNameFormatException();
		person2.setAge(person.getAge());
		dao.save(person2);
		return person2;
	}

	@Override
	public void deletePerson(int id) throws IdNotFoundException{
		Optional<Person> person=dao.findById(id);
		if(person.isEmpty())
			throw new IdNotFoundException();
		dao.deleteById(id);
	}

	@Override
	public Person updatePersonName(int id, String name)throws InvalidNameFormatException,IdNotFoundException {
		Optional<Person> person=dao.findById(id);
		if(person.isEmpty())
			throw new IdNotFoundException();
		Person person2=person.get();
		Matcher matcher = pattern.matcher(name);
		if (matcher.matches())
			person2.setName(name);
		else 
			throw new InvalidNameFormatException();
		person2.setName(name);
		dao.save(person2);
		return person2;
	}

	@Override
	public List<Person> getPersons() {
		return dao.findAll();
	}

}
