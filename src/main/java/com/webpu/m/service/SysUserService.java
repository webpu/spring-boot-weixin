package com.webpu.m.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.webpu.m.entity.SysUser;

public interface SysUserService {
	
	public void saveSysUser(SysUser sysUser);
	
	public void updateSysUser(SysUser sysUser);
	
	public void deleteUser(SysUser sysUser);
	
	public SysUser queryUserById(String userId);
	
	public List<SysUser> queryUserList(SysUser sysUser);
	
	public PageInfo queryUserListPage(SysUser sysUser,Integer page,Integer pageSize);	
	
	public SysUser getUser(SysUser sysUser); 
	
}
