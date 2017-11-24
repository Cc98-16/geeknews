package com.geeknews.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.geeknews.domain.User;
@Repository
@Transactional
public class UserDao extends BaseDao<User>{
	
	public void save(User user){
		try {
			getSession().save(user);
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
