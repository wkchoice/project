package network4;

	import java.io.BufferedReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.PrintWriter;
//	consoleâ�� �Է��� data�� memo.txt�� �����ϴ� ���α׷��� ������.
//	- /q�� �Է��ϸ� �Է� ����
//
//	�Է� : System.in�� �̿� + �Է��� ���ϰ� ���� Filter
//	��� : FileWriter + ����� ���ϰ� �� Filter
//
//	* �߰����� * 
//	�Է½� ctrl + z �� ������ null���� ���� �ǹǷ� ctrl + z �� ����Ǵ� ������ �߰��ؾ� ��

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
