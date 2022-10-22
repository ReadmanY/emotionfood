package com.team.emofood.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class User {
	private String uEmail;	// Email
	private String uname;	// 이름
	private String upw;	// 비번
	private int uage;	// 연령대 (연령대 = 9이면 admin 계정)
	private int ugend;	// 성별 0:선택안함 1:남 2:여
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") //input type="datetime-local"의 value
	private Date ujoindate;	// 가입일시
	
}
