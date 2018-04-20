package com.webpu.m.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_log")
public class SysLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 类型名
     */
    private String type;

    /**
     * 所在位置
     */
    private String location;

    /**
     * 内容
     */
    private String content;

    /**
     * 操作员工
     */
    @Column(name = "staff_id")
    private String staffId;

    /**
     * 时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取类型名
     *
     * @return type - 类型名
     */
    public String getType() {
        return type;
    }

    /**
     * 设置类型名
     *
     * @param type 类型名
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取所在位置
     *
     * @return location - 所在位置
     */
    public String getLocation() {
        return location;
    }

    /**
     * 设置所在位置
     *
     * @param location 所在位置
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * 获取内容
     *
     * @return content - 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取操作员工
     *
     * @return staff_id - 操作员工
     */
    public String getStaffId() {
        return staffId;
    }

    /**
     * 设置操作员工
     *
     * @param staffId 操作员工
     */
    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    /**
     * 获取时间
     *
     * @return create_time - 时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置时间
     *
     * @param createTime 时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}