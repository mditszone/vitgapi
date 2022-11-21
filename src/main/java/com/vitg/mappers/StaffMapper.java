package com.vitg.mappers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.vitg.dto.StaffDTO;
import com.vitg.entity.Staff;
import org.modelmapper.ModelMapper;

@Component
public class StaffMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	public StaffDTO staffToStaffDTO(Staff staff) {
		return modelMapper.map(staff,StaffDTO.class);
	}

	public Staff StaffDTOToStaff(StaffDTO staffDTO) {

		return modelMapper.map(staffDTO, Staff.class);
	}
} 
