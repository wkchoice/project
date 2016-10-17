package api;

public class StringEx1 {
	public static void main(String[] args) {
		String filePath = "C:\\Program Files\\MyApp\\테스트.txt";
		String fileName = filePath.substring(filePath.lastIndexOf("\\")+1); // 파일이름 추출하기
		
		System.out.println(fileName);
	}
}
