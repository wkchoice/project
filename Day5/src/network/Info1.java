package network;


public class Info1 {

	// http://stellan.tistory.com/category/Java%20Programing/Java%20����
	// http://stellan.tistory.com/trackback/82
	
//	Java Source File�� �ڵ� ����
//
//	1. package���� 
//	2. improt����
//	3. class ���� �� ���� - file �ϳ��� class �������� ���������� public class�� �ϳ��� ����
//
//	class�ȿ��� constructor, mothod, attribute ������ ��� ����. 
//	- ���������� attribute, constructor, mothod ������ ��.
	
//	�Է� Class��
//
//	InputStream
//	- 1 byte ������ �Է� ����
//
//	InputStream�� methods
//	read() : int 
//	- �о���� Data�� int type�� ������ ������ 1 byte�� ����
//	- EOF(������ ������)�� ������ -1�� return
//
//	read(byte[]) : int
//	- �о���� Data���� byte[]�� �� �������� ���� �� 1 byte�� ���� ������
//	- byte[]�� index�� return
//
//	close()
//	- ���ϰ� InputStream�� ������ ���� method
//	- ���Ͽ� �۾��� �� �� �����Ͽ� �۾��� �ϹǷ� ���� ������ ���� �� ���� �ƹ��� �۾��� �� �� ����.
	
//	Reader
//	- char(2 byte) ������ �Է� ����
//
//	Reader�� methods
//	read() : int
//	- �о���� Data�� int type�� ������ ������ 2 byte�� ����
//	- EOF(������ ������)�� ������ -1�� return
//
//	read(char[]) : int
//	- �о���� Data���� char[]�� �� �������� ���� �� char ���� 1���� ���� ������
//	- char[]�� index�� return
//
//	close()
//	- ���ϰ� Reader�� ������ ���� method
//	- ���Ͽ� �۾��� �� �� �����Ͽ� �۾��� �ϹǷ� ���� ������ ���� �� ���� �ƹ��� �۾��� �� �� ����.
	
//	��� Class
//
//	OutputStream
//	- 1 byte ������ �����
//
//	OutputStream�� methods
//	write(int) 
//	- �μ��� ���� Data�� ������ byte�� ���
//
//	write(byte[])
//	- byte[] ���� data���� �ѹ��� ���
//
//	write(byte[], int startIndex, int length)
//	- byte[]�迭���� data�� startIndex���� length��ŭ�� data�� ���
//
//	close()
//	- ���ϰ� OutputStream�� ������ ���� method
//	- ���Ͽ� �۾��� �� �� �����Ͽ� �۾��� �ϹǷ� ���� ������ ���� �� ���� �ƹ��� �۾��� �� �� ����.
//
//	flush()
//	- ���۸� �̿��ϴ� Stream�� ���� Data���� ���� ���
//
//	 
//
//	Writer
//	- char(2 byte) ������ �����
//
//	Writer�� methods
//	write(int)
//	- �μ��� ���� Data�� ������ 2 byte (char)�� ���
//
//	write(char[])
//	- char[] ���� data���� �ѹ��� ���
//
//	write(char[], int startIndex, int length)
//	- char[]�迭���� data�� startIndex���� length��ŭ�� data�� ���
//
//	write(String)
//	- String data�� ���
//
//	close()
//	- ���ϰ� Writer�� ������ ���� method
//	- ���Ͽ� �۾��� �� �� �����Ͽ� �۾��� �ϹǷ� ���� ������ ���� �� ���� �ƹ��� �۾��� �� �� ����.
//
//	flush()
//	- ���۸� �̿��ϴ� Stream�� ���� Data���� ���� ���

//	BufferedReader
//	����
//	- BufferedReader(Reader in)
//	- ������ ȣ��� Reader(Reader�� ��ӹ��� class��) ��ü�� ���ڷ� �޾� ����
//
//	methods
//	- readLine() : String // ����("\n")�� ������ �������� data�� �о����
//	- close() // ���Ϳ� ������ ������ ������
//
//	 
//
//	PrintWriter
//	����
//	- PrintWriter(File file) / PrintWriter(File file, true)
//	- ������ ȣ��� File(File�� ��ӹ��� class��) ��ü�� ���ڷ� �޾� ����
//	- ���ڷ� true�� �� ��� auto flush ( print�� �ٷ� flush() ȣ�� )
//
//	methods
//	- print(���dataType d) // ���ڷ� ���� data�� ����ִ� data�� ���
//	- println(���dataType d) // ���ڷ� ���� data�� ����ִ� data�� ����ϰ� �� �ٲ�
//	- flush() // ������ ������ ������ ��� (���۰迭�� ���۰� ���� ���߸� print�ϹǷ� ���ۿ� �����ִ� data�� ����ϱ� ���� ���)
//	- close() // flush() �޼��带 ȣ���Ͽ� �����ִ� data�� ��� ����ϰ� ���Ϳ� ������ ������ ����
	

//	super
//	- �θ��� ������ ȣ��� ���
//	- ������ �������� ù ��ɾ�� �;��� >> (this�� ������ �������� ù ��ɾ�� �;��ϹǷ� super�� this�� ���� ����� �� ����.)
//	- ������ �����ο� this()�� super()�� ������ super();�� �ڵ����� ��
//
//	��)
//	- EmployeeClass
//	public class Employee {
//	    public int salary;
//	    public Employee(int salary) {
//	        this.salary = salary;
//	    }
//	}
//	 
//	- ManagerClass 
//	public class Manager extends Employee{
//	    public String department;
//	}
//	 
//	- ���� ���� : 
//	Manager Ŭ������ default�����ڰ� �����Ǹ鼭 �⺻������ super()�� ȣ��
//	Employee Ŭ������ ���ڰ��� ���� �ʴ� �����ڰ� �����Ƿ� ������ �� 
//
//	- �ذ��� : 
//	Employee Ŭ������ ���ڰ��� ���� �ʴ� �����ڸ� �߰�


//	final�� ����
//	- �ѹ� ���� �ϸ� �� �̻� ��ȭ���� �ʴ� ����,�޼���,class �տ� �ٿ� ������ ���� ����. 
//
//	���� ���� ��ġ
//	- ����, �޼���(instance method), class
//
//	final�� ��ġ�� ���� ����
//	�޼���
//	- ���� class���� overriding�� �� �� ����.
//
//	class
//	- ���� class�� ���� �� ����.
//
//	����
//	- ������ ���ȭ ( ���� �����Ǹ� ���̻� ���� �Ұ��� ).
//	- instance ����: ������ �ʱ�ȭ�� �̷������ ����
//	- �� ���� : ����� ���� (�ʱ�ȭ) / �����ڿ��� ����
//	- instance �������� final�� �� ���� ����. -> �ַ� static�� ���� �Ἥ class������ ���
//
//	static����
//	- ����� ���� ������ �־�� ��.
//	- ���� ���� ���� �����Ƿ� �ַ� public ���������ڸ� �ٿ���.
//
//	��������
//	- �ʱ�ȭ�� �̷������ �ʱ� ������ ��� ���� ����.
//
//	final���� �̸� ����
//	- ��� �ܾ �빮�ڷ�.
//	- �ܾ�� �ܾ� ���̸� _�� ����
//	- ex) final int MAX_SIZE = 15;
	 
//	abstract
//	- instance�޼���, class�� ���Ǵ� ������
//	- �ǹ� : �߻����̴� -> ������ �� �Ǿ���.
//	- abstract method : �޼��� �������� ������ �޼���
//	- ��� ��) 
//	public abstract void go(); // {}�� ������ ������ �� ���̱� ������ {}�� ���̸� �ȵ�
//	 
//
//	- ���� class������ overriding�� ������. 
//	- ���� class���� ������ �޼����� template(Ʋ)�� �����ϴ� ����
//	- static�� �Բ� ���� �� ����. 
//
//	- abstract class
//
//
//	- ���� : �ڽ� class�� template, �ڽ� ��ü�� ���� Type����.
//	- abstract class�� ��ü ������ �� �� ����.
//	- ��� ��) 
//
//	public abstract class Animal{
//	}
//	 
//
//	- abstract method�� ���Ե� class�� �ݵ�� abstract class�� �Ǿ�� ��.
//	- �θ� class�� ���� �� abstract �޼��带 overriding ���� ������ abstract class�� �Ǿ�� ��.
//	- abstract class�� ������ �Ϲ� �޼��嵵 ���� �� �ִ�.
//	- abstract class�� ���� �� �ִ� ���
//
//	- �Ϲ� class
//	- Field
//	- ������
//	- �޼���
//	- �߻� �޼���
//
//
//	abstract�� UMLǥ��
//	- italicü�� ǥ�� 
//
//	interface
//	- �Ϻ��� �߻�ȭ�� ����
//	- ���� : 
//
//	- �θ�μ��� ����(�ڽ� class�� ���� type�� template ������ ���� ����).
//	- program�� �ٸ� class�鿡�� ����� �����(�ڵ�, �Һ��� ��) ����� ���
//	- ũ�� ���� ���� class���� �ϳ��� type���� ������ ���
//
//	- ��� ��)
//	public interface Interface { // [����������] interface interface�� [extends/implements ...] { }
//	    public static final int a = 0; // public, static, final ��������
//	    public abstract void go(); // public, abstract ���� ���� 
//	}
//	 
//
//	- ���� Ŭ������ �������� ����� �߻�ȭ �Ͽ� ����� ����(��� ������ ���� �ʰ�) �� ���� ��.
//	- Field�� static final ������ ���� �� �ִ�.
//	- abstract class�� �ٸ��� ������ �Ϲ� �޼��带 ���� �� ����.
//	- interface�� ��� ���� ���� Ŭ�������� �ݵ�� interface�� ����� �޼��带 overriding�ؾ� ��. (�޼��� ����� ���� �Ǿ� ���� �ʱ� ������)
//	- interface�� ��ü ������ �� �� ����. (�޼��� ��� ������ ���� �ʱ� ������)
//	- class�� interface�� ��� ���� �� ���� ����� �����ϴ�(implement�� ���� interface�� ���� �� �ִ�).
//
//
//	interface�� ���
//	- ��� ��)
//
//	public class SubClass implements Interface { // [����������] class class�� implements interface��, .... { }
//	}
//	 
//	- class -> class : extends, ���ϻ��
//	- interface -> interface : extends, ���߻��
//	- class -> interface : implements, ���߻��
//
//
//	interface�� UMLǥ��
//	- 
//
//	abstract class�� interface�� ������
//	- abstract class�� ������ method�� ���� �� ������ interface�� ������ method�� ���� �� ����.
//	- abstract class�� �����ڸ� ���� �� ������ interface�� �����ڸ� ���� �� ����.
//	- abstract class�� �ڽ� class���� ��ü ������ �θ�ü�� ������ ������ interface�� �θ�ü�� �������� �ʴ´� 
//	   (interface�� �����ڸ� ������ �ʱ⶧��)
}


