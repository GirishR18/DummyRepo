package working.datadrivenTesting;

import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJsonTest {

	public static void main(String[] args) throws Exception, ParseException {
		
		
		//FileReader fis = new FileReader("C:\\Users\\DELL\\Desktop\\CommonDataJson.json");
		//Step 1: Parse json physical file into java object using json parse class
		JSONParser parser = new JSONParser();
		
		//Object obj = parser.parse(fis);
		Object obj = parser.parse(new FileReader("C:\\Users\\DELL\\Desktop\\CommonDataJson.json"));
		
		//step 2:- convert java object into Json Object using downcasting
		JSONObject map = (JSONObject) obj;
		System.out.println(map.get("url"));
		System.out.println(map.get("browser"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("timeout"));
		System.out.println(map.get("env"));
		
	}

}
