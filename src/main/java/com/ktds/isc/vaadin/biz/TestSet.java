package com.ktds.isc.vaadin.biz;


/**
 * 
 * @author Alejandro Duarte.
 *
 */
public interface TestSet {
	
	Test[] getTests();
	
	void init();
	
	long getDefaultTimes();
	
	String getTitle();

	String getDescription();
	
}
