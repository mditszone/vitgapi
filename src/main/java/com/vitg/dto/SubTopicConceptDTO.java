package com.vitg.dto;



import lombok.Data;

@Data
public class SubTopicConceptDTO {
	private int id;	
	private String name;
	private String description;
	private String studentMaterial;
	private String trainerppt;
	private String examples;
	private String youtubeLink;
	private String githubLink;
	private String otherLink;
	private SubTopicDTO subTopic;
}
