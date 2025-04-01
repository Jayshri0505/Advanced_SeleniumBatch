package DDTPractice;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DDTByJsonfile {
	public static void main(String[] args) throws IOException, ParseException {
		JSONParser parser=new JSONParser();
		FileReader file=new FileReader("C:\\Users\\hp\\eclipse-workspace\\MyNewAdvancedJavaBatch\\src\\test\\resources\\Data_E18.json");
		Object javaObj = parser.parse(file);
		JSONObject obj=(JSONObject)javaObj;
		String name = obj.get("name").toString();
		String id = obj.get("id").toString();
		// Object id1 = obj.get("id").toString();
		 String branch = obj.get("Branch").toString();
			String age = obj.get("Age").toString();
			String student = obj.get("isStudent").toString();
			System.out.println(name);
			System.out.println(id);
			//System.out.println(id1);
			System.out.println(branch);
			System.out.println(age);
			System.out.println(student);

	}	

}

