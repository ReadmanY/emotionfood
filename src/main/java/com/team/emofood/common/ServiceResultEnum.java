package com.team.emofood.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ServiceResultEnum {
    ERROR("error"),

    SUCCESS("success"),

    DATA_NOT_EXIST("데이터를 찾을 수 없습니다"),

    SAME_CATEGORY_EXIST("같은 이름의 카테고리가 이미 존재합니다"),

    SAME_LOGIN_NAME_EXIST("사용자 이름이 이미 존재합니다"),

    LOGIN_NAME_NULL("ID를 입력하세요"),

    LOGIN_PASSWORD_NULL("비밀번호를 입력하세요"),

    LOGIN_ERROR("로그인 실패"),

    LOGIN_USER_LOCKED("사용자 로그인이 차단되었습니다"),

    OPERATE_ERROR("작업 실패"),

    NO_PERMISSION_ERROR("권한이 없습니다"),

    DB_ERROR("database error");

    private String result;

    public void setResult(String result) {
        this.result = result;
    }
}
