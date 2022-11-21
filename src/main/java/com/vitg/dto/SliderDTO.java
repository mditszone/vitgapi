package com.vitg.dto;

import lombok.Data;

@Data
public class SliderDTO {

	private int id;
	private String name;
	private boolean status;
	private byte[]  image;
	private byte[]  thumbImage;
	private String fileType;
	
}
