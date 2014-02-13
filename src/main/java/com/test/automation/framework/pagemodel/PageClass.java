package com.test.automation.framework.pagemodel;

import org.openqa.selenium.WebDriver;

import com.test.automation.framework.util.Utilities;

/**
 * Utility class to support Page classes for the Page Object Model implementation
 * @author  Varun Menon
 *
 */
public abstract class PageClass {
	
	protected Utilities util;
	public Browser browser;
	
	/**
	 * Intialization method for the Page class
	 * @param browser
	 */
	public void init(Browser browser){
		this.browser = browser;
		this.util = new Utilities();	
		this.init();
	}
	
	/**
	 * Sets the driver object for use with this page class.
	 * @param driver {@link WebDriver} object to be set for use.
	 */
	protected void setDriver(WebDriver driver){
		this.browser.setDriver(driver);
	}
	
	/**
	 * Returns the driver object(if set) for this Page class else return the driver object from the {@link Browser} class object.
	 * @return
	 */
	protected WebDriver getDriver(){
		return this.browser.getDriver();
	}
	
	/**
	 * Navigates to said page after appending the base url to Page url.
	 * This utility also verifies whether the driver is at the said Page by using "at" method of the Page after navigation. 
	 * @param pageClass - Page class extending {@link PageClass} to where the driver have to be navigated.
	 * @return The said page class object once verification is successful.
	 */
	protected <T> T to(Class<? extends PageClass> pageClass){
		T page = this.browser.to(pageClass);		
		return page;		
	}
	
	/**
	 * Utility to verify that the driver is at said page or not.
	 * @param pageClass Page class extending {@link PageClass} which have to verified to be on.
	 * @return The said page class object once verification is successful.
	 */
	protected <T> T at(Class<? extends PageClass> pageClass){
		T page = this.browser.at(pageClass);
		return page;
	}
	
	/**
	 * Similar to {@link #at(Class)} method, instead it return true or false based on the at verification done.
	 * @param pageClass Page class extending {@link PageClass} which have to verified to be on.
	 * @return true or false
	 */
	protected boolean isAt(Class<? extends PageClass> pageClass){
		return this.browser.isAt(pageClass);
	}
	
	/**
	 * The url for the said page. Please implement this method in your page classes and return the respective url for the page.
	 * In case the page dont have any url just return and empty string.	 * 
	 * 
	 * <p>
	 * <b>Note:</b>Do not append the base url to this url as it is automatically appended at runtime.
	 * @return - Page url without appending the base url.
	 */
	public abstract String toUrl();
	
	/**
	 * Method used to verify whether the driver object is on the said page or not.
	 * Return true or false based on the criteria to identify whether driver object is on the said page or not.
	 * 
	 * <p> This is a very important method as it will help in making you Page object model tests robust as it will help 
	 * you to validate the Page is shown before any of the util methods of the said page is executed.
	 * <b>Note:</b> For better results do not store your evaluated condition in a variable. Try to evaluate the success condition everytime this method gets executed. 
	 * @return true or false based on the page verification condition.
	 */
	public abstract boolean at();
	
	/**
	 * Use this method in case you want to initialize some variables or data while creating an Object of you Page class.
	 * This method will automatically get executed whenever you use {@link #to(Class)} or {@link #at(Class)} utils.
	 * In case you have nothing initialize just implement an empty method. 
	 */
	public abstract void init();

}
