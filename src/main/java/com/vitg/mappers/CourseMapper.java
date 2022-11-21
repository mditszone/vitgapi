package com.vitg.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.vitg.dto.CourseDTO;
import com.vitg.entity.Course;
import org.modelmapper.ModelMapper;

@Component
public class CourseMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public CourseDTO courseToCourseDTO(Course course) {
		return  modelMapper.map(course , CourseDTO.class);
	}

	public Course courseDTOToCourse(CourseDTO courseDTO) {

		return modelMapper.map(courseDTO, Course.class);
	}


}



