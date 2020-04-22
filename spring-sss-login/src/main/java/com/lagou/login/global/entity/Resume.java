package com.lagou.login.global.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Resume
 *
 * @author wanglinzhi
 * @date 2020/4/22
 */
@Data
@Entity
@Table(name = "tb_resume")
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String username;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private String phoneNo;
}
