package com.team.emofood.controller.admin;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.emofood.service.EmotLogService;
import com.team.emofood.util.PageQueryUtil;
import com.team.emofood.util.Result;
import com.team.emofood.util.ResultGenerator;

@Controller
@RequestMapping("/admin")
public class EmotlogController {

    @Resource
    private EmotLogService emotLogService;

    @GetMapping({"/logs"})
    public String index(HttpServletRequest request) {
        request.setAttribute("path", "logs");
        return "admin/log-list";
    }

    // 목록
    @RequestMapping(value = "/logs/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
        if (!StringUtils.hasText((CharSequence) params.get("page")) || !StringUtils.hasText((CharSequence) params.get("limit"))) {
            return ResultGenerator.genFailResult("파라미터가 비정상입니다！");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(emotLogService.getEmotLogPage(pageUtil));
    }
}
