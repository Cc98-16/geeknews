package com.geeknews.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.geeknews.domain.User;
import com.geeknews.valid.UserForm;
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
	
	public List<User> findbyaccount(String account){
		try {
			DetachedCriteria dc = DetachedCriteria.forClass(User.class);
			dc.add(Property.forName("account").eq(account));
			Criteria criteria = dc.getExecutableCriteria(getSession());
			return criteria.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public List<User> findByUser(UserForm userForm){
		try {
			DetachedCriteria dc = DetachedCriteria.forClass(User.class);
			dc.add(Property.forName("account").eq(userForm.getAccount()));
			dc.add(Property.forName("password").eq(userForm.getPassword()));
			Criteria criteria = dc.getExecutableCriteria(getSession());
			return criteria.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public User findById(String id){
		try {
			User user = getSession().get(User.class, id);
			return user;
		} catch (RuntimeException re) {
			throw re;
		}
	}
}
