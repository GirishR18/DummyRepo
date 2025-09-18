package discussed.questions;


import org.testng.*;

import org.testng.annotations.*;

public class FrameworkLifecycleLogger implements ITestListener, ISuiteListener {
	
	
	    // ========== TestNG Annotations ==========

	    @BeforeSuite
	    public void beforeSuite() {
	        System.out.println("  @BeforeSuite: Setup before suite execution");
	    }

	    @AfterSuite
	    public void afterSuite() {
	        System.out.println("  @AfterSuite: Cleanup after suite execution");
	    }

	    @BeforeClass
	    public void beforeClass() {
	        System.out.println("  @BeforeClass: Setup before each test class");
	    }

	    @AfterClass
	    public void afterClass() {
	        System.out.println("  @AfterClass: Cleanup after each test class");
	    }

	    @BeforeMethod
	    public void beforeMethod() {
	        System.out.println("  @BeforeMethod: Setup before each test method");
	    }

	    @AfterMethod
	    public void afterMethod() {
	        System.out.println("  @AfterMethod: Cleanup after each test method");
	    }

	    // ========== ISuiteListener methods ==========

	    @Override
	    public void onStart(ISuite suite) {
	        System.out.println("  ISuiteListener: Suite started - " + suite.getName());
	    }

	    @Override
	    public void onFinish(ISuite suite) {
	        System.out.println("  ISuiteListener: Suite finished - " + suite.getName());
	    }

	    // ========== ITestListener methods ==========

	    @Override
	    public void onTestStart(ITestResult result) {
	        System.out.println("  ITestListener: Test started - " + result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        System.out.println("  ITestListener: Test passed - " + result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        System.out.println("🟥 ITestListener: Test failed - " + result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        System.out.println(" ITestListener: Test skipped - " + result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        System.out.println(" ITestListener: Test failed but within success percentage - " + result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestFailedWithTimeout(ITestResult result) {
	        System.out.println(" ITestListener: Test failed due to timeout - " + result.getMethod().getMethodName());
	    }

	    @Override
	    public void onStart(ITestContext context) {
	        System.out.println(" ITestListener: Test context started - " + context.getName());
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        System.out.println(" ITestListener: Test context finished - " + context.getName());
	    }
	}



