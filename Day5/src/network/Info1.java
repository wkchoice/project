package network;


public class Info1 {

	// http://stellan.tistory.com/category/Java%20Programing/Java%20기초
	// http://stellan.tistory.com/trackback/82
	
//	BufferedReader
//	생성
//	- BufferedReader(Reader in)
//	- 생성자 호출시 Reader(Reader를 상속받은 class의) 객체를 인자로 받아 생성
//
//	methods
//	- readLine() : String // 엔터("\n")를 만나기 전까지의 data를 읽어들임
//	- close() // 필터와 파일의 연결을 해제함
//
//	 
//
//	PrintWriter
//	생성
//	- PrintWriter(File file) / PrintWriter(File file, true)
//	- 생성자 호출시 File(File을 상속받은 class의) 객체를 인자로 받아 생성
//	- 인자로 true를 줄 경우 auto flush ( print시 바로 flush() 호출 )
//
//	methods
//	- print(모든dataType d) // 인자로 받은 data에 들어있는 data를 출력
//	- println(모든dataType d) // 인자로 받은 data에 들어있는 data를 출력하고 줄 바꿈
//	- flush() // 강제로 버퍼의 내용을 출력 (버퍼계열은 버퍼가 가득 차야만 print하므로 버퍼에 남아있는 data를 출력하기 위해 사용)
//	- close() // flush() 메서드를 호출하여 남아있는 data를 모두 출력하고 필터와 파일의 연결을 해제
	
//	입력 Class들
//
//	InputStream
//	- 1 byte 단위로 입력 받음
//
//	 
//
//	InputStream의 methods
//	read() : int 
//	- 읽어들인 Data를 int type의 공간의 마지막 1 byte에 저장
//	- EOF(파일의 마지막)을 만나면 -1을 return
//
//	read(byte[]) : int
//	- 읽어들인 Data들을 byte[]에 꽉 찰때까지 넣은 후 1 byte씩 꺼내 저장함
//	- byte[]의 index를 return
//
//	close()
//	- 파일과 InputStream의 연결을 끊는 method
//	- 파일에 작업을 할 땐 점유하여 작업을 하므로 끊지 않으면 끊을 때 까지 아무도 작업을 할 수 없다.
	
//	Reader
//	- char(2 byte) 단위로 입력 받음
//
//	 
//
//	Reader의 methods
//	read() : int
//	- 읽어들인 Data를 int type의 공간의 마지막 2 byte에 저장
//	- EOF(파일의 마지막)을 만나면 -1을 return
//
//	read(char[]) : int
//	- 읽어들인 Data들을 char[]에 꽉 찰때까지 넣은 후 char 문자 1개씩 꺼내 저장함
//	- char[]의 index를 return
//
//	close()
//	- 파일과 Reader의 연결을 끊는 method
//	- 파일에 작업을 할 땐 점유하여 작업을 하므로 끊지 않으면 끊을 때 까지 아무도 작업을 할 수 없다.
	
//	출력 Class
//
//	OutputStream
//	- 1 byte 단위로 출력함
//
//	 
//
//	OutputStream의 methods
//	write(int) 
//	- 인수로 받은 Data의 마지막 byte를 출력
//
//	write(byte[])
//	- byte[] 내의 data들을 한번에 출력
//
//	write(byte[], int startIndex, int length)
//	- byte[]배열내의 data중 startIndex에서 length만큼의 data를 출력
//
//	close()
//	- 파일과 OutputStream의 연결을 끊는 method
//	- 파일에 작업을 할 땐 점유하여 작업을 하므로 끊지 않으면 끊을 때 까지 아무도 작업을 할 수 없다.
//
//	flush()
//	- 버퍼를 이용하는 Stream의 버퍼 Data들을 강제 출력
//
//	 
//
//	Writer
//	- char(2 byte) 단위로 출력함
//
//	 
//
//	Writer의 methods
//	write(int)
//	- 인수로 받은 Data의 마지막 2 byte (char)를 출력
//
//	write(char[])
//	- char[] 내의 data들을 한번에 출력
//
//	write(char[], int startIndex, int length)
//	- char[]배열내의 data중 startIndex에서 length만큼의 data를 출력
//
//	write(String)
//	- String data를 출력
//
//	close()
//	- 파일과 Writer의 연결을 끊는 method
//	- 파일에 작업을 할 땐 점유하여 작업을 하므로 끊지 않으면 끊을 때 까지 아무도 작업을 할 수 없다.
//
//	flush()
//	- 버퍼를 이용하는 Stream의 버퍼 Data들을 강제 출력






}
