package com.vitg.dto;

import lombok.Data;

@Data
public class StaffDTO {

	private int id;
	private String name;
	private String phoneNumber;
	private String aadharNumber;
	private String panCardNumber;
	private String gender;
	private String email;
	private RoleDTO role;
	private String roleName;
	private boolean registrationStatus;
	private byte[] image;
	private byte[] profPic;
	private byte[] aadharPic;
	private byte[] panCardPic;
}
