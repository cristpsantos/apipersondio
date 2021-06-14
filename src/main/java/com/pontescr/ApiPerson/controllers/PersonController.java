package com.pontescr.ApiPerson.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	@GetMapping
	@RequestMapping("/people")
	public String personTest() {
		
		return "Teste";
	}
}
