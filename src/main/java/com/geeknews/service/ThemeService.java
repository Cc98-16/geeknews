package com.geeknews.service;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.geeknews.dao.ThemeDao;
import com.geeknews.domain.Theme;
import com.geeknews.utils.ServiceException;
import com.geeknews.valid.ThemeForm;
@Service
public class ThemeService {
	@Resource
	private ThemeDao themeDao;
	
	public void ThemeSave(ThemeForm themeForm){
		try {
			String tname = themeForm.getThemename();
			
			/*Theme theme = themeDao.findbytname(tname);*/
			
			
			Theme theme = new Theme();
			
			theme.init();
			
			BeanUtils.copyProperties(themeForm, theme,Theme.class);
			
			themeDao.save(theme);
		} catch (ServiceException e) {
			throw e;
		}
		
	}
}
