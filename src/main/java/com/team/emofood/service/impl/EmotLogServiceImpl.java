package com.team.emofood.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.emofood.dto.EmotLog;
import com.team.emofood.mapper.EmotLogMapper;
import com.team.emofood.service.EmotLogService;
import com.team.emofood.util.PageQueryUtil;
import com.team.emofood.util.PageResult;

@Service
public class EmotLogServiceImpl implements EmotLogService {

    @Autowired
    private EmotLogMapper EmotLogMapper;

    @Override
    public PageResult getEmotLogPage(PageQueryUtil pageUtil) {
        List<EmotLog> EmotLogList = EmotLogMapper.findEmotLogList(pageUtil);
        int total = EmotLogMapper.getTotalEmotLog(pageUtil);
        PageResult pageResult = new PageResult(EmotLogList, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

}
