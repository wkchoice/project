package ws2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class FileAllTst {
}

class FileServer {
	public static void main(String[] args) {
		final int port=999;
		ServerSocket ss = new ServerSocket(port);
		Socket s = ss.accept();
		OutputStream outStream = s.getOutputStream();
		FileInputStream finStream = new FileInputStream("../desert.jpb");
		byte[] bytes = new byte[10000];
		int len = finStream.read(bytes);
		while (len != -1) {
			outStream.write(bytes,0,len);
			len = finStream.read(bytes);
		}
		// finStream/outStream/s.close();
	}
}
class FileClient {
	final int port = 999;
	Socket s = new Socket("a.b.c.d", port);
	InputStream inStream = s.getInputStream();
	FileOutputStream foutStream = new FileOutputStream("../download.jpb");
	byte[] bytes = new byte[1000];
	int len = inStream.read(bytes);
	
	while (len != -1) {
		foutStream.write(bytes, 0, len);
		len = inStream.read(bytes);
	}
	// foutStrem/inStream/s.close();
}

class FileWrite {
	Socket s = new Socket("a.b.c.d",  30);
	BufferedReader buffRead = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter printWrite = new PrintWriter(new FileWriter("./memo.txt"));
	while (true) {
		String inMsg = buffRead.readLine();
		printWrite.println(inMsg);
	}
	// buffRead/printWrite.close();
}


class MakeFile {
	private static File dir = new File("./Makefile");
	if (dir.exit == false) dir.mkdir();
	else {
		File file = new File("./MakeFile");
		if (file.createNewFile()) System.out.println(file.getName());
	}
}