package com.vitg.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vitg.dto.SubCourseDTO;

import com.vitg.entity.SubCourse;

import org.modelmapper.ModelMapper;

@Component
public class SubCourseMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public SubCourseDTO subCourseToSubCourseDTO(SubCourse subCourse) {
		return  modelMapper.map(subCourse , SubCourseDTO.class);
	}

	public SubCourse subCourseDTOToSubCourse(SubCourseDTO subCourseDTO) {

		return modelMapper.map(subCourseDTO, SubCourse.class);
	}
}


