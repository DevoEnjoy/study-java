package hashMapTest;

import org.json.JSONObject;


public class JSONTest {
	public static void main(String[] args) {
		User user = new User(1, "hds1234", "1234", "ÇÑµ¿¼®", 20);
		JSONObject userJSON = new JSONObject(user);
		System.out.println(userJSON);
		
//		JSONParser parser = new JSONParser();
//		try {
//			HashMap<String, Object> result = (HashMap)(parser.parse(userJSON.toString()));
//			System.out.println(result.get("number"));N
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
		
		
		
	}
}
