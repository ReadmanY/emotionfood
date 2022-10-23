package com.team.emofood.dto;

import lombok.Data;

@Data
public class KakaoInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kakao_info.kid
     *
     * @mbg.generated Sun Oct 23 17:41:39 KST 2022
     */
    private int kid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kakao_info.krate
     *
     * @mbg.generated Sun Oct 23 17:41:39 KST 2022
     */
    private float krate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kakao_info.kcount_rate
     *
     * @mbg.generated Sun Oct 23 17:41:39 KST 2022
     */
    private int kcountRate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kakao_info.kcount_blog
     *
     * @mbg.generated Sun Oct 23 17:41:39 KST 2022
     */
    private int kcountBlog;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kakao_info.kkeyword
     *
     * @mbg.generated Sun Oct 23 17:41:39 KST 2022
     */
    private String kkeyword;
}