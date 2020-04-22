package com.lagou.login.controller;

import com.lagou.login.global.entity.Result;
import com.lagou.login.global.entity.ResultBuilder;
import com.lagou.login.global.entity.Resume;
import com.lagou.login.service.ResumeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 资源接口
 *
 * @author wanglinzhi
 * @date 2020/4/22
 */
@Controller
@ResponseBody
@RequestMapping("/resume")
public class ResumeController {

    @Resource
    private ResumeService resumeService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result addResume(@RequestBody Resume resume) {
        resumeService.addResume(resume);
        return ResultBuilder.buildResultWithData(null);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result updateResume(@RequestBody Resume resume) {
        resumeService.updateResume(resume);
        return ResultBuilder.buildResultWithData(null);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result deleteResume(@RequestParam("id") Long resumeId) {
        resumeService.deleteResume(resumeId);
        return ResultBuilder.buildResultWithData(null);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result<List<Resume>> listAllResume() {
        return ResultBuilder.buildResultWithData(resumeService.listAllResume());
    }
}
