package com.webpu.m.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.webpu.m.common.utils.JsonUtils;
import com.webpu.m.common.utils.StringUtils;
import com.webpu.m.entity.SysUser;
import com.webpu.m.service.SysUserService;

@RestController
public class SysUserController {
	
	@Autowired
	private SysUserService sysUserService;
	
	@Autowired
	private Sid sid;
	
	@Autowired
	private StringRedisTemplate strRedis;
	
	@RequestMapping("/saveSysUser")
	public String saveSysUser(){
		String success = "save OK";
		String rndNo=sid.charShortNo("C",10);
		strRedis.opsForValue().set("username", "SimonWang");
		
		SysUser sysUser=new SysUser();
		sysUser.setName("wangyan");
		sysUser.setLoginPassword("123");
		sysUser.setLoginName(rndNo);
		sysUser.setCreateTime(new Date());
		sysUserService.saveSysUser(sysUser);

		SysUser sysUser2=new SysUser();
		sysUser2.setId(580);
		sysUser2=sysUserService.getUser(sysUser2);
		
		
		return JsonUtils.objectToJson(sysUser2);
	}
	@RequestMapping("/updateSysUser/{id}/{user}" )
	public String updateSysUser(@PathVariable Map<String,Object> sysUser){
		String success = "update OK";
		System.out.println(sysUser);
		return success;
	}
	
	@RequestMapping("/queryUserList/")
	public PageInfo querySysUserListPage(){
		
		return querySysUserListPage("1");
	}
	
	@RequestMapping("/queryUserList/{pageStr}")
	public PageInfo querySysUserListPage(@PathVariable("pageStr") String pageStr){
		
		if(!StringUtils.isNumeric(pageStr))
		{pageStr="1";}

		int page=Integer.parseInt(pageStr);
		
		int pageSize=10;
		SysUser user=new SysUser();
		//List<SysUser> userList=new ArrayList<SysUser>();
		//user.setId(300);
		PageInfo userList=sysUserService.queryUserListPage(user,page,pageSize);
		String success = "update OK";
		
		System.out.println(strRedis.opsForValue().get("username"));
		return userList;
	}
}
