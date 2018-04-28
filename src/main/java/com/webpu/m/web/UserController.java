package com.webpu.m.web;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webpu.m.entity.Resource;
import com.webpu.m.entity.SysUser;

@Controller
@RequestMapping(value = "/user") 
public class UserController {

	@Autowired
	private Resource resource;
	
	@Value("${sys.environment}")
	private String sysversion;	
	
	@ResponseBody
	@RequestMapping(value = "/login") 
	public SysUser userlogin(){
		
		SysUser su=new SysUser();
		su.setName("王岩");
		su.setLoginName("tears");
		//su.setCreateTime(new Date());
		int i= 1/0;
	 System.out.println("userLogin");
		
		return su;
	}
	
	@RequestMapping(value = "/fm") 
	//@ResponseBody
	public String getR(ModelMap map){
		
		Resource r=new Resource();
		//BeanUtils.copyProperties(resource, r);
		//r=resource;
		r.setName(resource.getName());
		r.setWebsite(resource.getWebsite());
		r.setCopyright(resource.getCopyright());
		System.out.println(r);
		map.addAttribute("re",r);
		return "freemarker/resource/index";
	}
	@RequestMapping(value = "/th") 
	//@ResponseBody
	public String getTh(ModelMap map){
		
		Resource r=new Resource();
		BeanUtils.copyProperties(resource, r);
		//r=resource;
		System.out.println(r);
		map.put("ver", sysversion);
		map.put("sys", r);
		map.addAttribute("re", map);
		
		return "thymeleaf/index";
	}

}
