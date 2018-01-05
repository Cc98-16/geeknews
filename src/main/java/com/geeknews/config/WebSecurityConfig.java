package com.geeknews.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Configuration
public class WebSecurityConfig extends WebMvcConfigurerAdapter{
	
	public final static String USERID = "seuserid";
	public final static String USER = "seuser";
	
    @Bean
    public SecurityInterceptor getSecurityInterceptor (){
		return new SecurityInterceptor();
    }
    
    public void addInterceptors(InterceptorRegistry registry){
    	InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());
    	
    	// 排除配置
    	addInterceptor.excludePathPatterns("/login");
    	addInterceptor.excludePathPatterns("/register");
    	addInterceptor.excludePathPatterns("/tarticle/{themeid}");
    	addInterceptor.excludePathPatterns("/");
    	addInterceptor.excludePathPatterns("/commentinput");
    	addInterceptor.excludePathPatterns("/replyinput");
    	addInterceptor.excludePathPatterns("/liked");
		// 拦截配置
		addInterceptor.addPathPatterns("/**");
    }
    class SecurityInterceptor extends HandlerInterceptorAdapter{
    	
    	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler)
    			throws Exception {
    				HttpSession session = request.getSession();
    				if(session.getAttribute(USER) != null )
    				return true;
    				
    				// 跳转登录
    				String url = "/login";
    				response.sendRedirect(url);
    				return false;
    			}
    	}
}
