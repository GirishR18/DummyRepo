package discussed.questions;




import org.testng.annotations.Test;

public class TestClass {

	

	public class ContactTests extends BaseClass {

	    @Test(invocationCount = 2, threadPoolSize = 2, priority = 1)
	    public void createContactTest() {
	        System.out.println("🔥 createContactTest: " + Thread.currentThread().getId());
	    }

	    @Test(dependsOnMethods = "createContactTest", priority = 2)
	    public void verifyContactTest() {
	        System.out.println("✅ verifyContactTest");
	    }

	    @Test(priority = 0, enabled = false)
	    public void skipThisTest() {
	        System.out.println("⛔ This should not run");
	    }

	    @Test(priority = 3, timeOut = 2000)
	    public void timeSensitiveTest() throws InterruptedException {
	        Thread.sleep(1000);  // Will pass
	        System.out.println("⏱️ timeSensitiveTest ran within timeout");
	    }

	    @Test(priority = 4, expectedExceptions = ArithmeticException.class)
	    public void exceptionTest() {
	        int result = 10 / 0; // Pass because exception is expected
	    }
	}

}
