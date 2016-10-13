package network4;

	import java.io.BufferedReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.PrintWriter;
//	console창에 입력한 data를 memo.txt에 저장하는 프로그램을 만들어보자.
//	- /q를 입력하면 입력 종료
//
//	입력 : System.in을 이용 + 입력을 편하게 받을 Filter
//	출력 : FileWriter + 출력을 편리하게 할 Filter
//
//	* 추가사항 * 
//	입력시 ctrl + z 를 누르면 null값이 들어가게 되므로 ctrl + z 시 종료되는 구문을 추가해야 함

	public class ConsoleToMemo {
	    public static void main(String[] args) {
	        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        PrintWriter printWriter = null;
	 
	        try {
	            printWriter = new PrintWriter(new FileWriter("./memo.txt"));
	             
	            while (true) {
	                String input = in.readLine();
	                if(input == null)
	                    break;
	                if (input.equals("/q"))
	                    break;
	                printWriter.println(input);
	                System.out.println(input.toString());
	                 
	                 
	            }
	            printWriter.flush();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        finally{
	            if(in != null){
	                try {
	                    in.close();
	                } catch (IOException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }
	            }
	            if (printWriter != null){
	                printWriter.close();
	            }
	        }
	 
	    }
	}
