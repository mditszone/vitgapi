
package com.vitg.dto;

import java.time.LocalDate;
import java.time.LocalTime;



import lombok.Data;

@Data
public class BatchDTO{
	private int id;
	private String name;
	//private String courseName;
	//private String subCourseName;
	//private String trainer;

	private LocalDate startDate;
	private LocalDate endDate;
	private LocalTime startTime;
	private LocalTime endTime;
	private String organizer;
	private SubCourseDTO subCourse;
}