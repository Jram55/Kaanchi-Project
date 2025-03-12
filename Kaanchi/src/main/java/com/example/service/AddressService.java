package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Address;
import com.example.repository.AddressRepository;

@Service
public class AddressService {

	
	@Autowired
	private AddressRepository addressrepo;

	public List<Address> getAddress() {
		
		return addressrepo.findAll();
	}

	public Address saveaddress(Address address) {
		
		return addressrepo.save(address);
	}

	public void deleteaddress(Long addressId) {
		
		addressrepo.deleteById(addressId);
		
	}
	
	

	
}
