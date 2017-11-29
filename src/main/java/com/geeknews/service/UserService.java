package com.geeknews.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.geeknews.dao.UserDao;
import com.geeknews.domain.User;
import com.geeknews.utils.ServiceException;
import com.geeknews.valid.UserForm;

@Service
public class UserService {
	
	@Resource
	private UserDao userDao;
	
	public void Register(UserForm userForm,String account){
		try {
			List<User> useraccount = userDao.findbyaccount(account);
			if(useraccount.size() > 0){
				throw new ServiceException("account","账号已存在");
			}else{
				User user = new User();
				user.init();
				
				BeanUtils.copyProperties(userForm, user, User.class);
				
				userDao.save(user);
			}
		} catch (ServiceException e) {
			throw e;
		}
	}
	
	public String Login(HttpSession httpSession,UserForm userForm){
		try {
			List<User> list = userDao.findByUser(userForm);
			if(list.size() <= 0){
				throw new ServiceException("password","账号或密码错误");
			}else{
				User user = list.get(0);
				httpSession.setAttribute("seuser", user);
			}
			return "success";
		} catch (ServiceException e) {
			throw e;
		}
	}
}
