package discussed.questions;

import org.testng.annotations.Test;

public class MainAndTestStaticNonStaticMethods {
	
	public static void m1() {
		System.out.println("m1 is running");
	}
	
	public  void m2() {
		System.out.println("m2 is running");
	}
	public  void m3() {
		System.out.println("m3 is running");
	}
	
	@Test
	public void a() {
		System.out.println("Method Test 1 is executed");
	}
	
	@Test
	public void c() {
		System.out.println("Method Test 2 is executed");
	}
	
	@Test
	public void b() {
		System.out.println("Method Test 3 is executed");
	}

	public static void main(String[] args) {
		MainAndTestStaticNonStaticMethods.m1();
		MainAndTestStaticNonStaticMethods ref = new MainAndTestStaticNonStaticMethods();
		ref.m2();
		ref.m3();
		
	}

}
