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
		// �ڹ� ��ũ��Ʈ�� ��ü�� �ƴϴ�.
		JSONObject obj = new JSONObject();// ���̽� ǥ����� ���ؼ� ���ڿ��� �����.
		obj.put("name", "ȫ�浿");
		obj.put("age", 20);
		obj.put("tall", 190.7);
		obj.put("male", true);
		String str = obj.toString();
		System.out.println(str);
		// ��ȯ�� ���̽� ����� : {"male":true,"age":20,"name":"ȫ�浿","tall":190.7}
	}

	public static void test2() throws JSONException {
		CustomerDTO cdto = new CustomerDTO("id_111", "���缮", 20000, true);
		JSONObject obj = new JSONObject(cdto);
		System.out.println(obj);
		// ��ȯ�� ���̽� ����� :
		// {"id":"id_111","mileage":20000,"name":"���缮","marriage":true}
	}

	public static void test3() throws JSONException {
		CustomerDTO cdto1 = new CustomerDTO("id_111", "���缮", 20000, true);
		CustomerDTO cdto2 = new CustomerDTO("id_222", "���缮", 20000, true);
		CustomerDTO cdto3 = new CustomerDTO("id_333", "���缮", 20000, true);
		JSONObject ctoJSON1 = new JSONObject(cdto1);
		JSONObject ctoJSON2 = new JSONObject(cdto2);
		JSONObject ctoJSON3 = new JSONObject(cdto3);
		JSONObject obj = new JSONObject();
		obj.put("cdto1", ctoJSON1); // cdto�� ���̽����� ��ȯ�ϴ°��� �ƴ϶� cdto�� ���� Ÿ������ �𸣹Ƿ�
									// cdto.toString()�� ȣ��
		obj.put("cdto2", ctoJSON2);
		obj.put("cdto3", ctoJSON3);
		System.out.println(obj);
	}

	public static void test4() throws JSONException {
		CustomerDTO cdto1 = new CustomerDTO("id_111", "���缮", 20000, true);
		CustomerDTO cdto2 = new CustomerDTO("id_222", "��", 10000, true);
		CustomerDTO cdto3 = new CustomerDTO("id_333", "�ڸ��", 25000, true);
		ArrayList<CustomerDTO> list = new ArrayList<CustomerDTO>();
		list.add(cdto1);
		list.add(cdto2);
		list.add(cdto3);
		JSONObject obj = new JSONObject();
		obj.put("customers", list);
		System.out.println(obj);
	}

	//// JSONArray�̿� - �ڹٽ�ũ��Ʈ �迭������ ���ڿ�
	public static void test5() throws JSONException {
		JSONArray arr = new JSONArray();
		arr.put("�̼���");
		arr.put(false);
		arr.put(10000);
		arr.put(20.48);
		System.out.println(arr);

	}

	public static void test6() throws JSONException {
		// ArrayList list = new ArrayList();
		// list.add("ȫ�浿");
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
		CustomerDTO cdto1 = new CustomerDTO("id_111", "���缮", 20000, true);
		CustomerDTO cdto2 = new CustomerDTO("id_222", "��", 10000, true);
		CustomerDTO cdto3 = new CustomerDTO("id_333", "�ڸ��", 25000, true);
		ArrayList list = new ArrayList();
		list.add(cdto1);
		list.add(cdto2);
		list.add(cdto3);
		JSONArray arr = new JSONArray(list);
		System.out.println(arr);
	}


}
