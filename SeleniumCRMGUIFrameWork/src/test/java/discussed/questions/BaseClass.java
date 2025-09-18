package discussed.questions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

    @BeforeSuite(alwaysRun = true)
    public void configBS() {
        System.out.println("📦 Before Suite - Setup DB connection");
    }

    @BeforeClass(alwaysRun = true)
    public void configBC() {
        System.out.println("🚀 Before Class - Launch Browser");
    }

    @BeforeMethod(alwaysRun = true)
    public void configBM() {
        System.out.println("🔑 Before Method - Login");
    }

    @AfterMethod(alwaysRun = true)
    public void configAM() {
        System.out.println("🔒 After Method - Logout");
    }

    @AfterClass(alwaysRun = true)
    public void configAC() {
        System.out.println("❌ After Class - Close Browser");
    }

    @AfterSuite(alwaysRun = true)
    public void configAS() {
        System.out.println("📦 After Suite - Close DB connection");
    }
}