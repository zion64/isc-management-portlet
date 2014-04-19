package com.ktds.isc.vaadin;

import javax.servlet.annotation.WebServlet;

import com.ktds.isc.repo.RequestofdeletingsmartsheetHome;
import com.ktds.isc.util.SpringContextHelper;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("vaadin7test")
public class NewVaadinPortletUI extends UI  {


	/**
     * Default constructor. 
     */
    public NewVaadinPortletUI() {
    }

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = NewVaadinPortletUI.class)
	public static class Servlet extends VaadinServlet {

	}
    
	@Override
	protected void init(VaadinRequest request) {
		SpringContextHelper helper = new SpringContextHelper(VaadinServlet.getCurrent().getServletContext());
		final VerticalLayout content = new VerticalLayout();
		final RequestofdeletingsmartsheetHome bean = (RequestofdeletingsmartsheetHome) helper.getBean("requestofdeletingsmartsheetHome");
		content.setMargin(true);
		setContent(content);
		// Create the content root layout for the UI
		setContent(content);

		Button button = new Button("Click Me");
		button.addClickListener(new Button.ClickListener() {
			/**
			 * 
			 */
			private static final long	serialVersionUID	= 1L;

			public void buttonClick(ClickEvent event) {
				content.addComponent(new Label(String.valueOf(bean.findById(2).getUser().getUsername())));
			}
		});
		content.addComponent(button);
	}
}
