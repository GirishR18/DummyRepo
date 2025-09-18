package working.datadrivenTesting;

public class ReadDataRuntimeParameter {

	public static void main(String[] args) {
		
		System.out.println(args.length);
		for(String ele : args) {
			System.out.println(ele);
		}
	}

}
