package discussed.questions;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(discussed.questions.FrameworkLifecycleLogger.class)
	public class TestClassForListner {
	    @Test
	    public void demoTest() {
	        System.out.println("🚀 Test is running");
	    }
	}


