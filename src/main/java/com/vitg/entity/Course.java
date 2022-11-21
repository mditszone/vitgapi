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
@Table(name = "course")
public class Course  implements Serializable{
	
	private static final long serialVersionUID = 4130758031076098234L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;	
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "image", length = 1000)
	private byte[] image;
	
	@Column(name = "status")
	private boolean Status;
	
	@Column(name = "description")
	private String description;
	
}
