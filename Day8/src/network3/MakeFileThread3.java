package network3;

	import java.io.File;
	import java.io.IOException;
	 
	public class MakeFileThread3 implements Runnable {
	 
	    @Override
	    public void run() {
	        // 1�ʸ��� �ϳ��� ������ ���� -> 1�е���
	        try {
	            File dir = new File("./ResultFile");
	            if (!dir.exists()) {
	                dir.mkdir();
	            } else {
	                File file = null;
	                for (int i = 1; i <= 60; i++) {
	                    file = new File("./ResultFile/����." + i);
	                    if (file.createNewFile()) {
	                        System.out.println(file.getName() + " ���� �Ϸ�");
	                    }
	                    try {
	                        Thread.sleep(1000);
	                    } catch (InterruptedException e) {
	                        // TODO Auto-generated catch block
	                        e.printStackTrace();
	                    }
	                }
	            }
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	 
	    }
	 
	}
