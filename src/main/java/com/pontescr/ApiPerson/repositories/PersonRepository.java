package com.pontescr.ApiPerson.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pontescr.ApiPerson.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
