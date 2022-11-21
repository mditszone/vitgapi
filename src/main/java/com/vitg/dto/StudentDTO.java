package com.vitg.dto;

import lombok.Data;

@Data
public class StudentDTO {

	private int id;
	private String name;
	private String phoneNumber;
	private String gender;
	private String email;
	private byte[] profPic;
//	private RoleDTO role;
//	private String roleName;
	private boolean registrationStatus;
	private byte[] image;
}
