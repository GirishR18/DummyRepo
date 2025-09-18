package com.pack1;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CreateOrgTest {
	
	@BeforeSuite
	public void configBS() {
		System.out.println(" BS ");
	}
	

	@BeforeClass
	public void configBC() {
		System.out.println("BC ");
	}

	@BeforeMethod
	public void configBM() {
		System.out.println("BM");
	}

	@Test
	public void createContact() {
		System.out.println("Contact is created");
	}
	
	@Test
	public void createContactDate() {
		System.out.println("createContact with Date is created");
	}

	@AfterMethod
	public void configAM() {
		System.out.println("AM ");
	}
	
	@AfterClass
	public void configAC() {
		System.out.println("Ac ");
	}

	@AfterSuite
	public void configAS() {
		System.out.println("AS ");
	}
	

}
