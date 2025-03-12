package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Address;
import com.example.service.AddressService;

@RestController
@RequestMapping("/address")
@CrossOrigin
public class AddressController {

	@Autowired
	private AddressService addressservice;
	
	
	@GetMapping
	public List<Address> getAll(){
		
		return addressservice.getAddress();
	}
	
	@PostMapping
	public ResponseEntity<Address> save(@RequestBody Address address){
		
		addressservice.saveaddress(address);
		return new ResponseEntity<>(address,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/addressId")
	public void delete(@PathVariable Long addressId){
		
		addressservice.deleteaddress(addressId);
		
	}
}
