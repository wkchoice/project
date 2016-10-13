package network3;

public class ThreadTest3 {
//	1초마다 파일을 생성하는 Thread와 20초마다 생성된 파일을 이동하는 Thread를 만들어 보자
//	Thread 1
//	- 1초마다 파일을 생성 (~~.1, ~~.2 ....)
//
//	Thread 2 
//	- 20초마다 파일을 이동 (Thread 1에서 생성된 모든 파일들을 다른 경로로 이동)
//
//	Thread 1
//	1. 파일 객체를 생성하여 새로운 파일을 만듬
//	2. 1초간 휴식
//
//	Thread 2
//	1. 파일 객체를 생성
//	2. 파일을 새로운 경로로 이동
//	3. 파일이 존재하지 않을때까지 1~2를 반복
//	4. 20초간 휴식

	    public static void main(String[] args) {
	        Thread makeFileThread = new Thread(new MakeFileThread3());
	        Thread moveFileThread = new Thread(new MovieFileThread3());
	 
	        makeFileThread.start();
	        moveFileThread.start();
	    }
	}
