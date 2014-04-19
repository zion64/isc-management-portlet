/*----------------------------------------------------------------------------*/
/* Source File:   SECONDPORTLETCONTROLLER.JAVA                                */
/* Description:   Controller Class for 'firstportlet' portlet.                */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Jul.16/2013                                                 */
/* Last Modified: Jul.16/2013                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2013 CSoftZ                                                 */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Jul.16/2013 COQ  File created.
 -----------------------------------------------------------------------------*/

package com.ktds.isc.controller;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

/**
 * Controller Class for 'firstportlet' portlet
 * 
 * If you want to use Spring Web MVC Porlet then follow the instructions
 * contained in this article <a href=
 * 'http://www.opensource-techblog.com/2012/09/spring-mvc-portlet-in-liferay.html'>Spring
 * MVC Portlet in Liferay</a>. Here you will use the Annotated Classes for
 * Spring Framework 2.5.x, in this portlet Spring Framework 3.2.3.RELEASE is
 * used. You can also follow the documentation contained in the official Spring
 * Framework doc site. http://static.springsource.org/spring/docs
 * /3.2.x/spring-framework-reference/html/portlet.html
 * 
 * A reference also is: <a href=
 * 'http://portalhub.wordpress.com/2012/05/12/spring-mvc-portlet-hello-world-based-on-annotations'>Spring
 * MVC Portlet Hello World with annotations</a>
 * 
 * @since 1.5(JDK), Jul.16/2013
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Jul.16/2013
 */

@RequestMapping("VIEW")
@Controller("smartSheetPortletController")
public class SmartSheetPortletController {
	@ExceptionHandler({ Exception.class })
	public String handleException() {
		return "errorPage";
	}

	@RenderMapping
	public String showHomePage(RenderRequest request, RenderResponse response) {
		return "smartsheet/show";

	}
}
