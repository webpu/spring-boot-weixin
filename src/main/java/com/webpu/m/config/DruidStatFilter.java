package com.webpu.m.config;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import com.alibaba.druid.support.http.WebStatFilter;
/**   
 * 配置监控拦截器 
 * druid监控拦截器   
 * @ClassName: DruidFilter    
 * @author SimonWang   
 * @date 2018-04-12   
 */    
@WebFilter(filterName = "druidWebStatFilter", urlPatterns = "/*",
initParams = {@WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")// 忽略的资源
})
public class DruidStatFilter extends WebStatFilter {
	
}

