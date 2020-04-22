package com.lagou.login.dao;

import com.lagou.login.global.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * com.lagou.niancheng.login.dao.ResumeRepostry
 *
 * @author wanglinzhi
 * @date 2020/4/22
 */
@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {

}
