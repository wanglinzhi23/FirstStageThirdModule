package com.lagou.login.service.impl;

import com.lagou.login.dao.ResumeRepository;
import com.lagou.login.global.entity.Resume;
import com.lagou.login.global.exceptions.MyErrorCode;
import com.lagou.login.global.exceptions.MyException;
import com.lagou.login.service.ResumeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * ResumeServiceImpl
 *
 * @author wanglinzhi
 * @date 2020/4/22
 */
@Service
public class ResumeServiceImpl implements ResumeService {

    @Resource
    private ResumeRepository resumeRepository;

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void addResume(Resume resume) {
        // 参数检查
        checkAddResumeParam(resume);
        // 执行插入操作
        resumeRepository.save(resume);
    }


    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void updateResume(Resume resume) {
        // 参数检查
        checkUpdateResumeParam(resume);
        // 执行更新操作
        resumeRepository.save(resume);
    }


    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void deleteResume(Long resumeId) {
        resumeRepository.deleteById(resumeId);
    }

    @Override
    public List<Resume> listAllResume() {
        return resumeRepository.findAll();
    }

    private void checkAddResumeParam(Resume resume) {
        resume.setId(null);
        checkNotNull("username", resume.getUsername());
        checkNotNull("address", resume.getAddress());
        checkNotNull("phoneNo", resume.getPhoneNo());
    }

    private void checkUpdateResumeParam(Resume resume) {
        checkNotNull("id", resume.getId());
        checkNotNull("username", resume.getUsername());
        checkNotNull("address", resume.getAddress());
        checkNotNull("phoneNo", resume.getPhoneNo());
    }

    private void checkNotNull(String paramName, Object param) {
        if (param == null) {
            throw new MyException(MyErrorCode.PARAM_ERROR, paramName);
        }
        if (param instanceof String) {
            if (StringUtils.isEmpty(param)) {
                throw new MyException(MyErrorCode.PARAM_ERROR, paramName);
            }
        }
    }
}
