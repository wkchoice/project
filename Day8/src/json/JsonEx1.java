package json;

//jsonÇü½Ä ==> {"jsontest":[{"name":"Mr.Cho","location":"Seoul"}]}

import java.util.Iterator;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonEx1 {
	public static void main(String[] ar) {
		String s = "{\"jsontest\":[{\"name\":\"Mr.Cho\",\"location\":\"Seoul\"}]}";
		JSONObject jo = JSONObject.fromObject(s);

		JSONArray ja = jo.getJSONArray("jsontest");

		for (Iterator i = ja.iterator(); i.hasNext();) {
			JSONObject ob = (JSONObject) i.next();

			String a = ob.getString("name");
			String b = ob.getString("location");

			System.out.println(a);
			System.out.println(b);
		}
	}
}
