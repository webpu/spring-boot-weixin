package com.webpu.m.web;

import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webpu.m.entity.SysUser;
import com.webpu.m.service.SysUserService;

@RestController
public class SysUserController {
	
	@Autowired
	private SysUserService sysUserService;
	
	@Autowired
	private Sid sid;
	
	@RequestMapping("/saveSysUser")
	public String saveSysUser(){
		String success = "save OK";
		String rndNo=sid.charShortNo("C",10);
		
		
		SysUser sysUser=new SysUser();
		sysUser.setName("wangyan");
		sysUser.setLoginPassword("123");
		sysUser.setLoginName(rndNo);
		sysUserService.saveSysUser(sysUser);
		
		
		return success;
	}

}
