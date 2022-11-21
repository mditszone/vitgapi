package com.vitg.entity;
import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = " SubTopicConcept ")
public class  SubTopicConcept   implements Serializable{
	private static final long serialVersionUID = 4130758031076098234L;	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;	
	
	
	@Column(name = "name")
	private String name;
	
	
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "student_material")
	private String studentMaterial;
	
	
	
	@Column(name = "trainer_ppt")
	private String trainerppt;
	
	@Column(name = "examples")
	private String examples;
	
	@Column(name = "youtube_link")
	private String youtubeLink;
	
	
	
	@Column(name = "github_link")
	private String githubLink;
	
	@Column(name = "other_link")
	private String otherLink;
	
	@OneToOne( targetEntity = SubTopic.class)
	@JoinColumn(name = "subTopic_id", referencedColumnName = "id")
	private SubTopic subTopic;
}

