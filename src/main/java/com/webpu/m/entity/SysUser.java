package com.webpu.m.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user")
public class SysUser {
    /**
     * ID自动
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 登陆名
     */
    @Column(name = "login_name")
    private String loginName;

    /**
     * 登陆密码
     */
    @Column(name = "login_password")
    private String loginPassword;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取ID自动
     *
     * @return id - ID自动
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置ID自动
     *
     * @param id ID自动
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return name - 用户名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户名
     *
     * @param name 用户名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取登陆名
     *
     * @return login_name - 登陆名
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 设置登陆名
     *
     * @param loginName 登陆名
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * 获取登陆密码
     *
     * @return login_password - 登陆密码
     */
    public String getLoginPassword() {
        return loginPassword;
    }

    /**
     * 设置登陆密码
     *
     * @param loginPassword 登陆密码
     */
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}