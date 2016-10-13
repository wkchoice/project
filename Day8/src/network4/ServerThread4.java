package network4;

	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.PrintWriter;
	import java.net.Socket;
	 
	public class ServerThread4 implements Runnable {
	 
	    /*
	     * Thread Ŭ����
	     * Socket�� �޾� �׿� ����� Ŭ���̾�Ʈ�� ������ ���� �а�
	     * �ٽ� Ŭ���̾�Ʈ�� ����
	     */
	    private Socket socket;
	     
	     
	     
	    public ServerThread4(Socket socket) {
	        this.socket = socket;
	    }
	 
	 
	 
	    @Override
	    public void run() {
	        // TODO Auto-generated method stub
	        BufferedReader bufferedReader = null;
	        PrintWriter printWriter = null;
	        try {
	            while(true){
	                 
	                bufferedReader = new BufferedReader(new InputStreamReader( socket.getInputStream()));
	                printWriter = new PrintWriter(socket.getOutputStream(), true);
	                 
	                String str = bufferedReader.readLine();
	                if(str == null){
	                    System.out.println("client ���� ����");
	                    break;
	                }
	                 
	                System.out.println("client�� ���� ���� message : " + str);
	                 
	                printWriter.println(str);
	            }
	              
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        finally {
	            if(bufferedReader != null){
	                try {
	                    bufferedReader.close();
	                } catch (IOException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }
	            }
	            if(printWriter != null){
	                printWriter.close();
	            }
	            if(socket != null){
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
