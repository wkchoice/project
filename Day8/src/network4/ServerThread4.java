package network4;

	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.PrintWriter;
	import java.net.Socket;
	 
	public class ServerThread4 implements Runnable {
	 
	    /*
	     * Thread 클래스
	     * Socket을 받아 그에 연결된 클라이언트가 보내는 글을 읽고
	     * 다시 클라이언트에 전송
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
	                    System.out.println("client 연결 해제");
	                    break;
	                }
	                 
	                System.out.println("client로 부터 받은 message : " + str);
	                 
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
