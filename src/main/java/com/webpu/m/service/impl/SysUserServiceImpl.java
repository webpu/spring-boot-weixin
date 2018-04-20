package com.webpu.m.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webpu.m.entity.SysUser;
import com.webpu.m.mapper.SysUserMapper;
import com.webpu.m.service.SysUserService;

@Service
@Transactional(readOnly = false)
public class SysUserServiceImpl implements SysUserService{

	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Override
	public void saveSysUser(SysUser sysUser) {
		sysUserMapper.insert(sysUser);
	}

	@Override
	public void updateSysUser(SysUser sysUser) {
		sysUserMapper.updateByPrimaryKeySelective(sysUser);
	}

	@Override
	public void deleteUser(SysUser sysUser) {
		sysUserMapper.deleteByPrimaryKey(sysUser);
	}

	@Override
	public SysUser queryUserById(String userId) {
		return sysUserMapper.selectByPrimaryKey(userId);
	}

	@Override
	public List<SysUser> queryUserList(SysUser sysUser) {
		List<SysUser> userList = sysUserMapper.selectByExample(sysUser);
		return userList;
	}
	

}
