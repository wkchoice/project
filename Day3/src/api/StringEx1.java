package api;

public class StringEx1 {
	public static void main(String[] args) {
		String filePath = "C:\\Program Files\\MyApp\\�׽�Ʈ.txt";
		String fileName = filePath.substring(filePath.lastIndexOf("\\")+1); // �����̸� �����ϱ�
		
		System.out.println(fileName);
	}
}
