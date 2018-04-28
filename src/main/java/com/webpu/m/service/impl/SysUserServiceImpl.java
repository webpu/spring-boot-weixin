package com.webpu.m.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.webpu.m.entity.SysUser;
import com.webpu.m.mapper.SysUserMapper;
import com.webpu.m.service.SysUserService;

import tk.mybatis.mapper.entity.Example;

@Service
@Transactional(readOnly = false)
public class SysUserServiceImpl implements SysUserService{

	@Autowired
	private SysUserMapper sysUserMapper;
	
	//@Transactional
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

	@Override
	public SysUser getUser(SysUser sysUser) {
		SysUser userList = sysUserMapper.getUser(sysUser);
		return userList;
	}
	
	//分页
	@Override
	public PageInfo queryUserListPage(SysUser sysUser,Integer page,Integer pageSize) {
		//引入分页查询，使用PageHelper分页功能  
	    //在查询之前传入当前页，然后多少记录  
		PageHelper.startPage(page,pageSize);
	    //startPage后紧跟的这个查询就是分页查询  
//	    List<Employee> emps = employeeService.getAll();  
	    //使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以  
	    
	    //pageINfo封装了分页的详细信息，也可以指定连续显示的页数  
	  
		Example example=new Example(SysUser.class);
		Example.Criteria criteria=example.createCriteria();
		
		
		 
		if(!StringUtils.isEmptyOrWhitespace(sysUser.getName())){
			criteria.andLike("name", "%"+sysUser.getName() + "%");
		}
		
		example.orderBy("id");
		
		List<SysUser> userList = sysUserMapper.selectByExample(example);
		//pageINfo封装了分页的详细信息，也可以指定连续显示的页数  
		PageInfo pageInfo = new PageInfo<>(userList,pageSize); 
		
		return pageInfo;
	}	
	

}
