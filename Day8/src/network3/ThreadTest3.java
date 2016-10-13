package network3;

public class ThreadTest3 {
	    public static void main(String[] args) {
	        Thread makeFileThread = new Thread(new MakeFileThread3());
	        Thread moveFileThread = new Thread(new MovieFileThread3());
	 
	        makeFileThread.start();
	        moveFileThread.start();
	    }
	}
