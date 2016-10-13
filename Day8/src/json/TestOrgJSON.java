package json;

import java.util.ArrayList;
import json.test.CustomerDTO.CustomerDTO;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TestOrgJSON {
	public static void main(String[] args) throws JSONException {
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
		test7();
		
	}
	
	public static void test1() throws JSONException {
		// 자바 스크립트의 객체는 아니다.
		JSONObject obj = new JSONObject();// 제이슨 표기법에 의해서 문자열만 만든다.
		obj.put("name", "홍길동");
		obj.put("age", 20);
		obj.put("tall", 190.7);
		obj.put("male", true);
		String str = obj.toString();
		System.out.println(str);
		// 변환된 제이슨 결과값 : {"male":true,"age":20,"name":"홍길동","tall":190.7}
	}

	public static void test2() throws JSONException {
		CustomerDTO cdto = new CustomerDTO("id_111", "유재석", 20000, true);
		JSONObject obj = new JSONObject(cdto);
		System.out.println(obj);
		// 변환된 제이슨 결과값 :
		// {"id":"id_111","mileage":20000,"name":"유재석","marriage":true}
	}

	public static void test3() throws JSONException {
		CustomerDTO cdto1 = new CustomerDTO("id_111", "유재석", 20000, true);
		CustomerDTO cdto2 = new CustomerDTO("id_222", "유재석", 20000, true);
		CustomerDTO cdto3 = new CustomerDTO("id_333", "유재석", 20000, true);
		JSONObject ctoJSON1 = new JSONObject(cdto1);
		JSONObject ctoJSON2 = new JSONObject(cdto2);
		JSONObject ctoJSON3 = new JSONObject(cdto3);
		JSONObject obj = new JSONObject();
		obj.put("cdto1", ctoJSON1); // cdto를 제이슨으로 변환하는것이 아니라 cdto가 무슨 타입인지 모르므로
									// cdto.toString()을 호출
		obj.put("cdto2", ctoJSON2);
		obj.put("cdto3", ctoJSON3);
		System.out.println(obj);
	}

	public static void test4() throws JSONException {
		CustomerDTO cdto1 = new CustomerDTO("id_111", "유재석", 20000, true);
		CustomerDTO cdto2 = new CustomerDTO("id_222", "길", 10000, true);
		CustomerDTO cdto3 = new CustomerDTO("id_333", "박명수", 25000, true);
		ArrayList<CustomerDTO> list = new ArrayList<CustomerDTO>();
		list.add(cdto1);
		list.add(cdto2);
		list.add(cdto3);
		JSONObject obj = new JSONObject();
		obj.put("customers", list);
		System.out.println(obj);
	}

	//// JSONArray이용 - 자바스크립트 배열형태의 문자열
	public static void test5() throws JSONException {
		JSONArray arr = new JSONArray();
		arr.put("이순신");
		arr.put(false);
		arr.put(10000);
		arr.put(20.48);
		System.out.println(arr);

	}

	public static void test6() throws JSONException {
		// ArrayList list = new ArrayList();
		// list.add("홍길동");
		// list.add(false);
		// list.add(10000);
		// list.add(222.1);
		String[] list = { "aaa", "bbb", "ccc", "ddd" };
		JSONArray arr = new JSONArray(list);
		JSONObject obj = new JSONObject();
		obj.put("list", arr);
		System.out.println(arr);
		System.out.println(obj);

	}

	public static void test7() throws JSONException {
		CustomerDTO cdto1 = new CustomerDTO("id_111", "유재석", 20000, true);
		CustomerDTO cdto2 = new CustomerDTO("id_222", "길", 10000, true);
		CustomerDTO cdto3 = new CustomerDTO("id_333", "박명수", 25000, true);
		ArrayList list = new ArrayList();
		list.add(cdto1);
		list.add(cdto2);
		list.add(cdto3);
		JSONArray arr = new JSONArray(list);
		System.out.println(arr);
	}


}
