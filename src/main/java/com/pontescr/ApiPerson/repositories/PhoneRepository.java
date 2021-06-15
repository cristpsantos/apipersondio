package com.pontescr.ApiPerson.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pontescr.ApiPerson.entities.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
