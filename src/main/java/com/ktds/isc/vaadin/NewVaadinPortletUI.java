package com.ktds.isc.vaadin;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("liferay")
@SuppressWarnings("serial")
public class NewVaadinPortletUI extends UI {
	
	@Override
	protected void init(VaadinRequest request) {
        // Create the content root layout for the UI
        VerticalLayout content = new VerticalLayout();
        setContent(content);

        // Needed because the composites are full size
        content.setSizeFull();

        MyComp myComposite = new MyComp();
        content.addComponent(myComposite);
	}
}
