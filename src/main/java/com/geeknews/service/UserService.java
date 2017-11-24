package com.geeknews.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.geeknews.dao.UserDao;
import com.geeknews.domain.User;
import com.geeknews.utils.ServiceException;
import com.geeknews.valid.UserForm;

@Service
@Transactional
public class UserService {
	
	@Resource
	private UserDao userDao;
	
	public void Register(UserForm userForm){
		try {
			User user = new User();
			user.init();
			
			BeanUtils.copyProperties(userForm, user, User.class);
			
			userDao.save(user);
		} catch (ServiceException e) {
			throw e;
		}
	}
}
