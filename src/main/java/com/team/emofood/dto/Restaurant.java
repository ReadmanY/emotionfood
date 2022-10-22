package com.team.emofood.dto;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class Restaurant {
	private int rid;
	private String rname;
	private String rcate;
	private String raddr;
	private String raddr_gu;
	private String rphone;
	private float rlocate_x;
	private float rloacte_y;
	private int kid;
}
