package sampleTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import webdriverlistenerImp.WebDriverLinsterImp;

	public class SampleTestWebLinsterImp {
	    public static void main(String[] args) {
	    	WebDriver originalDriver = new ChromeDriver();
	    	WebDriver decoratedDriver = new EventFiringDecorator<>(new WebDriverLinsterImp()).decorate(originalDriver);

	    	// Use the decorated driver (NOT the original driver)
	    	decoratedDriver.get("https://www.facebook.com/");

	    	// Intentional failure - wrong locator to trigger listener
	    	decoratedDriver.findElement(By.id("nonExistentId")).click();

	    	decoratedDriver.quit();

	    }
	}


