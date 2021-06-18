package com.pontescr.ApiPerson.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pontescr.ApiPerson.dto.PersonDTO;
import com.pontescr.ApiPerson.entities.Person;
import com.pontescr.ApiPerson.exception.PersonNotFoundException;
import com.pontescr.ApiPerson.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;
	
	@Transactional
	public PersonDTO insert(PersonDTO dto) {
		Person person = new Person(dto);
		repository.save(person);
		return new PersonDTO(person);
	}
	
	@Transactional
	public PersonDTO updateById(Long id, PersonDTO dto) throws PersonNotFoundException {
		verifyIfExists(id);
		Person person = new Person(dto);
		repository.save(person);
		return new PersonDTO(person);
	}
	
	@Transactional(readOnly = true)
	public List<PersonDTO> findAll() {
		List<Person> person = repository.findAll();
		return person.stream().map(x -> new PersonDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public PersonDTO findById(Long id) throws PersonNotFoundException {
		Person person = verifyIfExists(id);
		return new PersonDTO(person);
	}
	
	@Transactional
	public void deleteById(Long id) throws PersonNotFoundException {
		verifyIfExists(id);
		repository.deleteById(id);
	}
	
    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }
}
