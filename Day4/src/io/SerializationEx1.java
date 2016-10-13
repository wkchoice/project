package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationEx1 { // ��ü�� serialization
	public static void main(String[] args) throws IOException {
		Student s1 = new Student("S001", "ȫ�浢", 30);
		Student s2 = new Student("S002", "�ڱ浢", 20);
		
		FileOutputStream fos = new FileOutputStream("Student.dat");
		
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s1);
		oos.writeObject(s2);
		oos.close();
	}
}
