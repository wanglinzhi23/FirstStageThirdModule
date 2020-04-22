package com.lagou.login.service;

import com.lagou.login.global.entity.Resume;

import java.util.List;

/**
 * ResumeService
 *
 * @author wanglinzhi
 * @date 2020/4/22
 */
public interface ResumeService {

    void addResume(Resume resume);

    void updateResume(Resume resume);

    void deleteResume(Long resumeId);

    List<Resume> listAllResume();
}
