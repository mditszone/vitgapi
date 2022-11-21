
package com.vitg.dto;

import java.time.LocalDate;

import java.time.LocalTime;


import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class TrackDTO{
	private int id;
	private String remarks;
	private LocalDate date;
	private LocalTime startTime;
	private LocalTime endTime;
	private String topicsCovered;
	
}