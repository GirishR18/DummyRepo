package working.datadrivenTesting;

public class GenerateAlphanumericRandomValues {

	public static void main(String[] args) {
		int n = 20;
		//Random random = new Random();
		String AlaphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		
		StringBuilder sb = new StringBuilder(n);
		
		for(int i =0; i<n;i++) {
			int index= (int) (AlaphaNumericString.length()*Math.random());
			sb.append(AlaphaNumericString.charAt(index));
			
		}
		System.out.println(sb);
	}

}
