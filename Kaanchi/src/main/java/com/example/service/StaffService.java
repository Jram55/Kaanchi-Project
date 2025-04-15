package com.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.StaffDto;
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

	public List<StaffDto> getall() {
		
		List<Staff> staff=staffrepo.findAll();
		
		return staff.stream().map(this::mapToBasicDto).collect(Collectors.toList());
	}

	private StaffDto mapToBasicDto(Staff staff) {
	    StaffDto dto = new StaffDto();
	    dto.setStaffId(staff.getStaffId());
	    dto.setStaffName(staff.getStaffName());
	    dto.setStaffNumber(staff.getStaffNumber());
	    dto.setGender(staff.getGender());
	    dto.setDoB(staff.getDoB());
	    dto.setDoJ(staff.getDoJ());
	    dto.setDesignation(staff.getDesignation());
	    dto.setPhoto(staff.getPhoto());
	    dto.setQulification(staff.getQulification());
	    dto.setSpecialization(staff.getSpecialization());
	    dto.setDOR(staff.getDOR());
	    dto.setReleavingReason(staff.getReleavingReason());
	    dto.setRecordId(staff.getRecordId());
	    dto.setDeleted(staff.isDeleted());
	    return dto;
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
