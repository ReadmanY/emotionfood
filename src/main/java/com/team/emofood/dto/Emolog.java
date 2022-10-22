package com.team.emofood.dto;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

public class Emolog {

	private int eid;
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") //input type="datetime-local"의 value
	private Date etime;
	private String eemote;
	private float elocate_x;
	private float elocate_y;
	private String uemail;
}
