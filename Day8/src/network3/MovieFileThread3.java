package network3;

	import java.io.File;
	 
	public class MovieFileThread3 implements Runnable {
	 
	    @Override
	    public void run() {
	        // TODO Auto-generated method stub
	 
	        try {
	            int fileIndex = 1;
	            File dir = new File("./MovedFile");
	            if (!dir.exists()) {
	                dir.mkdir();
	            }
	 
	            else {
	                for (int i = 1; i <= 3; i++) {
	                    Thread.sleep(20000);
	                    File file = null;
	                    while (true) {
	                        file = new File("./ResultFile/헤헤." + fileIndex);
	                        if (!file.exists()) {
	                            break;
	                        }
	                        file.renameTo(new File("./MovedFile/헤헤." + fileIndex));
	                        fileIndex++;
	 
	                    }
	                    System.out.println("이동완료");
	                }
	 
	            }
	        } catch (InterruptedException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	 
	}

