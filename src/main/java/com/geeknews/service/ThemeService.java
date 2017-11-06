package com.geeknews.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.geeknews.dao.ThemeDao;
import com.geeknews.domain.Theme;
import com.geeknews.utils.MyPage;
import com.geeknews.utils.ServiceException;
import com.geeknews.valid.ThemeForm;
@Service
public class ThemeService {
	@Resource
	private ThemeDao themeDao;
	
	public void ThemeSave(ThemeForm themeForm,String tname){
		try {
			List<Theme> themename = themeDao.findbytname(tname);
			if(themename!=null && !themename.isEmpty()){
				throw new ServiceException("themename","主题已存在，请勿重复重建");
			}else{
				Theme theme = new Theme();
				
				theme.init();
				
				BeanUtils.copyProperties(themeForm, theme,Theme.class);
				
				themeDao.save(theme);
			}

		} catch (ServiceException e) {
			throw e;
		}
	}
	
	public MyPage<Theme> findAll(String keyword,int page,int pagesize){
		try{
			return themeDao.findAll(keyword,page,pagesize);		
		}catch(ServiceException e){
			throw e;
		}
	}
}
