package working.datadrivenTesting;

import java.util.Random;

public class GenerateRandomNumber {

	public static void main(String[] args) {
		Random random = new Random();
		int randomInt = random.nextInt(2000);
		System.out.println(randomInt);
	}

}
