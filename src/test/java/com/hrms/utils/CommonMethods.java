package com.hrms.utils;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrms.testbase.BaseClass;
import com.hrms.testbase.PageInitializer;

public class CommonMethods extends PageInitializer {

	/**
	 * Method that sends text to any given element
	 * 
	 * @param element
	 * @param text
	 */

	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	/**
	 * Method return Object of JavaScript Executer type
	 * 
	 * @return js object
	 */
	public static JavascriptExecutor getJSExecuter() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;

	}

	/**
	 * Methods performs click using JavaScript executer
	 * 
	 * @param element
	 */

	public static void jsClick(WebElement element) {
		getJSExecuter().executeScript("argument[0].click()", element);
	}

	/**
	 * Methods scrolls up using JavaScript executor
	 * 
	 * @param pixel
	 */
	public static void scrollUp(int pixel) {
		getJSExecuter().executeScript("window.scrollBy(0, -" + pixel + ")");
	}

	/**
	 * Methods scrolls down using JavaScript executor
	 * 
	 * @param pixel
	 */
	public static void scrollDown(int pixel) {
		getJSExecuter().executeScript("window.scrollBy(0," + pixel + ")");
	}

	public static WebDriverWait getWaitObject() {
		return new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);
	}

	public static void waitForClickability(WebElement element) {
		getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void click(WebElement element) {
		waitForClickability(element);
		element.click();
	}

	/**
	 * Method that will take a screenshot and store with name in specified location
	 * with .png extension
	 * 
	 * @param fileName
	 */
	public static byte[] takeScreenshot(String fileName) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] bytes =ts.getScreenshotAs(OutputType.BYTES);
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(Constants.SCREENSHOT_FILEPATH + fileName +getTimeStamp("yyyy-MM-dd-HH-mm-ss")+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bytes;
		
		/**
		 * This method will generate timeStamp
		 * 
		 */
	}
	 public static String getTimeStamp(String pattern){
	        Date date = new Date();
	        //pattern YYYY-MM-DD-HH-MM-SS-MS
	        //to format the date according to our choice we have a function
	        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
	        return sdf.format(date);


}
	
}