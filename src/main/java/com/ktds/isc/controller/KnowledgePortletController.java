/*----------------------------------------------------------------------------*/
/* Source File:  */
/* Description:  */ 
/* Author: */
/* Date:  */
/* Last Modified:  */ 
/* Version:  */
/* Copyright (c), 2014  */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Jul.16/2013 COQ  File created.
 -----------------------------------------------------------------------------*/

/*
 * Jul.16/2013 If you want to use Spring Web MVC Porlet then follow the
 * instructions contained in this article Here you will use the Annotated
 * Classes for Spring Framework 2.5.x, in this portlet Spring Framework
 * 3.2.3.RELEASE is used. You can also follow the documentation contained in the
 * official Spring Framework doc site.
 * http://static.springsource.org/spring/docs
 * /3.2.x/spring-framework-reference/html/portlet.html
 * 
 * A reference also is:
 * http://portalhub.wordpress.com/2012/05/12/spring-mvc-portlet
 * -hello-world-based-on-annotations
 */
package com.ktds.isc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.ktds.isc.repo.RequestofdeletingsmartsheetHome;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;

@RequestMapping("VIEW")
@Controller("knowledgePortletController")
public class KnowledgePortletController {
	private static Logger					_log	= LoggerFactory.getLogger(KnowledgePortletController.class);

	@Autowired(required = false)
	private RequestofdeletingsmartsheetHome requestofdeletingsmartsheetHome;

//	@InitBinder
//	protected void initBinder(WebDataBinder binder) {
//	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
//	}
	
	@RenderMapping
	public String showHomePage(RenderRequest request, RenderResponse response, Model model) {
		_log.info("Inside KnowledgePortletController -> showHomePage");
		model.addAttribute("smartsheets", requestofdeletingsmartsheetHome.findAllSortedDesc());
		try {
			User user = PortalUtil.getUser(request);//user.getFullName()
			model.addAttribute("user", user);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "knowledge/show";
//		return "smartsheet/show";
	}
}
