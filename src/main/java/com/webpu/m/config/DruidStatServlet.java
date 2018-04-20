package com.webpu.m.config;

import com.alibaba.druid.support.http.StatViewServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
/**   
 * druid监控视图配置   
 * @ClassName: DruidServlet    
 * @author SimonWang   
 * @date 2018-04-12 
 */   

@WebServlet(urlPatterns = "/druid/*",
    initParams={
            @WebInitParam(name="allow",value="127.0.0.1"),// IP白名单 
            @WebInitParam(name="deny",value="192.168.1.1"),// IP黑名单
            @WebInitParam(name="loginUsername",value="admin"),// 用户名
            @WebInitParam(name="loginPassword",value="admin"),// 密码
            @WebInitParam(name="resetEnable",value="false")// 禁用“Reset All”功能
    })
public class DruidStatServlet extends StatViewServlet{
	private static final long serialVersionUID = 2359758657306626394L;  
}
