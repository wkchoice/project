package networkdb;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer0 {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket(1818);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		FileInputStream fileInputStream = null;
		OutputStream outputStreamWriter = null;

		Socket socket = null;

		try {
			socket = serverSocket.accept();

			OutputStream outputStream = socket.getOutputStream();

			fileInputStream = new FileInputStream("../desert.jpg");

			byte[] dataBuff = new byte[10000];
			int length = fileInputStream.read(dataBuff);
			while (length != -1) {
				outputStream.write(dataBuff, 0, length);
				length = fileInputStream.read(dataBuff);
			}
			System.out.println("전송 선공");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (outputStreamWriter != null) {
				try {
					outputStreamWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
