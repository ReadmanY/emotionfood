package com.team.emofood.dto;

import lombok.Builder;
import lombok.Data;
@Data
public class Restaurant {

	private KakaoInfo kakaoInfo;

	private int rid;
	private String rname;
	private String rcate;
	private String raddr;
	private String raddr_gu;
	private String rphone;
	private float rlocate_x;
	private float rloacte_y;
	private int kid;

	@Builder
    public Restaurant(KakaoInfo kakaoInfo, int rid, String rname, String rcate, String raddr, String raddr_gu, String rphone, float rlocate_x, float rloacte_y){
        this.kakaoInfo = kakaoInfo;
		this.rid = rid;
        this.rname = rname;
        this.rcate = rcate;
		this.raddr = raddr;
		this.raddr_gu = raddr_gu;
		this.rphone = rphone;
		this.rlocate_x = rlocate_x;
		this.rloacte_y = rloacte_y;
	}
}
