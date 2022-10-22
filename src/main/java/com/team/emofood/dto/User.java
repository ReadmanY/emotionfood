package com.team.emofood.dto;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class User {
	private String uEmail;
	private String uname;
	private String upw;
	private int uage;
	private int ugend;
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") //input type="datetime-local"의 value
	private Date ujoindate;
	
}
