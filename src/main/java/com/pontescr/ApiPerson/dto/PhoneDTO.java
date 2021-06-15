package com.pontescr.ApiPerson.dto;

import com.pontescr.ApiPerson.entities.Phone;
import com.pontescr.ApiPerson.enums.PhoneType;

public class PhoneDTO {

	private Long id;
	private PhoneType phoneType;
	private String number;
	
	public PhoneDTO() {
	}

	public PhoneDTO(Long id, PhoneType phoneType, String number) {
		this.id = id;
		this.phoneType = phoneType;
		this.number = number;
	}
	
	public PhoneDTO(Phone phone) {
		id = phone.getId();
		phoneType = phone.getPhoneType();
		number = phone.getNumber();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PhoneType getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(PhoneType phoneType) {
		this.phoneType = phoneType;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
