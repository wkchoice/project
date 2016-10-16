
//----------------------------------------------------------- //
public class FileServer0 {
	public final static int port = 50005;
	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(port);
		} catch (IOException e) {	}

		FileInputStream fileInputStream = null;
		OutputStream outputStreamWriter = null;
		Socket s = null;
		try {
			s = serverSocket.accept();
			OutputStream outputStream = s.getOutputStream();
			fileInputStream = new FileInputStream("../desert.jpg");
			byte[] dataBuff = new byte[10000];
			int length = fileInputStream.read(dataBuff);
			while (length != -1) {
				outputStream.write(dataBuff, 0, length);
				length = fileInputStream.read(dataBuff);
			}
			System.out.println("전송 선공");

		} catch (IOException e) {}
		fileInputStream.close();
		outputStreamWriter.close();
		s.close();
	}
}
//----------------------------------------------------------- //
public class FileClient0 {
	public static void main(String[] args) {
		Socket s = null;
		InputStreamReader inputStreamReader = null;
		FileOutputStream fileOutputStream = null;
		try {
			s = new Socket("127.0.0.1", 1818);
			InputStream inputStream = s.getInputStream();
			fileOutputStream = new FileOutputStream("./download.jpg");
			byte[] dataBuff = new byte[10000];
			int length = inputStream.read(dataBuff);
			System.out.print("다운중 ");
			while (length != -1) {
				System.out.print(".");
				fileOutputStream.write(dataBuff, 0, length);
				length = inputStream.read(dataBuff);
			}
			System.out.println("파일 저장 성공");

		} catch (IOException e) {}
		fileOutputStream.close();
		inputStreamReader.close();
		socket.close();

	}
}
//----------------------------------------------------------- //
File dir = new File("./ResultFile"); // make file
if (!dir.exists()) {
	dir.mkdir();
} else {
	File file = new File("./ResultFile/헤헤." + i);
	if (file.createNewFile()) {
		System.out.println(file.getName() + " 생성 완료");
	}
}
//----------------------------------------------------------- //
BufferedReader buffRead = new BufferedReader(new InputStreamReader(System.in)); // write file
PrintWriter printWrite = null;
try {
	printWrite = new PrintWriter(new FileWriter("./memo.txt"));
	while (true) {
		String input = buffRead.readLine();
		if(input == null) break;
		if (input.equals("/q"))	break;
		printWrite.println(input);
	}
	printWrite.flush();
} catch (IOException e) { }
buffRead.close();
printWriter.close();

