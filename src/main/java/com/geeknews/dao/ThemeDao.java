package com.geeknews.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.geeknews.domain.Theme;
@Repository
@Transactional
public class ThemeDao extends BaseDao<Theme>{
	public void save(Theme theme) {
		log.debug("saving Event instance");
		try {
			getSession().save(theme);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
}
