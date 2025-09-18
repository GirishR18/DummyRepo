package discussed.questions;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class MultipleConfgAnnotations {
	
	@BeforeSuite
	public void configBS() {
		System.out.println(" BS ");
	}
	
	
	@BeforeSuite
	public void configBS1() {
		System.out.println(" BS1 ");
	}

	@BeforeClass
	public void configBC1() {
		System.out.println("BC1 ");
	}

	
	@BeforeClass
	public void configBC() {
		System.out.println("BC ");
	}

	
	@BeforeMethod
	public void configBM() {
		System.out.println("BM");
	}

	
	@BeforeMethod
	public void configBM2() {
		System.out.println("BM2");
	}
	@Test
	public void createContact() {
		System.out.println("Contact is created");
	}
//	
//	@Test
//	public void createContactDate() {
//		System.out.println("createContact with Date is created");
//	}

	@AfterMethod
	public void configAM() {
		System.out.println("AM ");
	}
	
	@AfterMethod
	public void configAM1() {
		System.out.println("AM1 ");
	}
	
	@AfterClass
	public void configAC() {
		System.out.println("Ac ");
	}
	
	@AfterClass
	public void configAC1() {
		System.out.println("Ac1 ");
	}

	@AfterSuite
	public void configAS() {
		System.out.println("AS ");
	}
	
	@AfterSuite
	public void configAS1() {
		System.out.println("AS 1");
	}
	


}
