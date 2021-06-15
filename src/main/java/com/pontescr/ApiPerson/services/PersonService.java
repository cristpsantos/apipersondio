package com.pontescr.ApiPerson.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pontescr.ApiPerson.dto.PersonDTO;
import com.pontescr.ApiPerson.dto.PhoneDTO;
import com.pontescr.ApiPerson.entities.Person;
import com.pontescr.ApiPerson.entities.Phone;
import com.pontescr.ApiPerson.repositories.PersonRepository;
import com.pontescr.ApiPerson.repositories.PhoneRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private PhoneRepository phoneRepository;
	
	@Transactional
	public PersonDTO insert(PersonDTO dto) {
		Person person = new Person(null, dto.getFirstName(), dto.getLastName(), dto.getCpf(), dto.getBirthDate());
		for(PhoneDTO ph : dto.getPhones()) {
			Phone phone = phoneRepository.getById(ph.getId());
			person.getPhones().add(phone);			
		}
		person = repository.save(person);
		return new PersonDTO(person);
	}
	
	public List<PersonDTO> findAll() {
		List<Person> person = repository.findAll();
		return person.stream().map(x -> new PersonDTO(x)).collect(Collectors.toList());
	}
}
