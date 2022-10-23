package com.team.emofood.service;

import com.team.emofood.dto.User;
import com.team.emofood.util.PageQueryUtil;
import com.team.emofood.util.PageResult;

public interface UserService {
    // 백엔드
    // 상품 정보 가져오기
    PageResult getUserPage(PageQueryUtil pageUtil);


}
