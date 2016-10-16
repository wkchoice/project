package networkdb;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class FileClient0 {
	public static void main(String[] args) {

		Socket socket = null;
		InputStreamReader inputStreamReader = null;
		FileOutputStream fileOutputStream = null;

		try {
			socket = new Socket("127.0.0.1", 50005);
			InputStream inputStream = socket.getInputStream();

			fileOutputStream = new FileOutputStream("./download.jpg");
			byte[] dataBuff = new byte[10000];
			int length = inputStream.read(dataBuff);
			System.out.print("�ٿ��� ");
			while (length != -1) {
				System.out.print(".");
				fileOutputStream.write(dataBuff, 0, length);
				length = inputStream.read(dataBuff);

			}
			System.out.println();

			System.out.println("���� ���� ����");

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (inputStreamReader != null) {
				try {
					inputStreamReader.close();
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
