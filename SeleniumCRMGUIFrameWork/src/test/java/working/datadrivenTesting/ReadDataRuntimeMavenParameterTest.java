package working.datadrivenTesting;

import org.testng.annotations.Test;

public class ReadDataRuntimeMavenParameterTest {
	@Test
	public void mavenTest() {
		String url =System.getProperty("url");
		System.out.println("Env Data==> URL====> "+url);
	}

}
