package com.geeknews.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.geeknews.domain.Comment;

@Repository
@Transactional
public class CommentDao extends BaseDao<Comment>{
	
	public void save(Comment comment) {
		log.debug("saving Event instance");
		try {
			getSession().save(comment);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
}
