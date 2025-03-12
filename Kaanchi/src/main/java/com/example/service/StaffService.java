package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Department;
import com.example.entity.Staff;
import com.example.repository.DepartmentRepository;
import com.example.repository.StaffRepository;

@Service
public class StaffService {
	
	@Autowired
	private StaffRepository staffrepo;
	
	@Autowired
	private DepartmentRepository departmentrepo;

	public List<Staff> getall() {
		
		return staffrepo.findAll();
	}

	public Staff getstaffById(Long staffId) {
	
		return staffrepo.findById(staffId).orElse(null);
		
	}

	public Staff savestaff(Staff staff) {
		
		return staffrepo.save(staff);
		
	}

	public void deleteservice(Long staffId) {
		
		staffrepo.deleteById(staffId);
	}

	public Staff savestaffDepartment(long departmentId, long staffId) {
		
		Department department=departmentrepo.findById(departmentId).orElseThrow(()->
		new RuntimeException("Departent is not found"));
		
		Staff staff=staffrepo.findById(staffId).orElseThrow(()->
		new RuntimeException("staff not found"));
		
		staff.setDepartment(department);
		return staffrepo.save(staff);
	}
	
	
	
	

}
