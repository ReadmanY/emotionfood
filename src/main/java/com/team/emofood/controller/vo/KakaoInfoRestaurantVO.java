package com.team.emofood.controller.vo;

import com.team.emofood.dto.KakaoInfo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class KakaoInfoRestaurantVO {
    //kid, rid, rname, rcate, raddr, raddr_gu, rphone, rlocate_x, rlocate_y, krate, kcount_rate, kcount_blog, kkeyword

    /*
     * SELECT *
     * FROM emofood.restaurant
     * NATURAL JOIN emofood.kakao_info
     */

    private int rid;
	private String rname;
	private String rcate;
	private String raddr;
	private String raddrGu;
	private String rphone;
	private float rlocateX;
	private float rlocateY;

    private int kid;
    private float krate;
    private int kcountRate;
    private int kcountBlog;
    private String kkeyword;
}
