package com.pontescr.ApiPerson.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.pontescr.ApiPerson.dto.PhoneDTO;
import com.pontescr.ApiPerson.enums.PhoneType;

@Entity
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private PhoneType phoneType;
	
	@Column(nullable = false)
	private String number;
	
	public Phone() {
		
	}
	
	public Phone(PhoneDTO phoneDTO) {
		id = phoneDTO.getId();
		phoneType = phoneDTO.getPhoneType();
		number = phoneDTO.getNumber();
	}
	
	public Phone(Long id, PhoneType phoneType, String number) {
		this.id = id;
		this.phoneType = phoneType;
		this.number = number;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phone other = (Phone) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
		
}
