package api;

import java.io.UnsupportedEncodingException;

public class StringByte {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String msg = "æ»≥Á«œººø‰?";
		byte[] bytes = msg.getBytes("UTF-8");
		
		String msg2 = new String(bytes);
		System.out.println("msg2:"+msg2);
		
		String msg3 = new String(bytes, "UTF-8");
		System.out.println("msg3:"+msg3);
		
	}
}
