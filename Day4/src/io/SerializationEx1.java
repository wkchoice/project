package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationEx1 { // °´Ã¼ÀÇ serialization
	public static void main(String[] args) throws IOException {
		Student s1 = new Student("S001", "È«±æµ¢", 30);
		
		FileOutputStream fos = new FileOutputStream("Student.dat");
		
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s1);
		oos.close();
	}
}
