package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

public class DeserializationEx1 {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("Student.dat");
		
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Student s1 = (Student)ois.readObject();
		ois.close();
		
		s1.displayInfo();
	}
}
