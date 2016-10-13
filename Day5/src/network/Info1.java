package network;


public class Info1 {

	// http://stellan.tistory.com/category/Java%20Programing/Java%20기초
	// http://stellan.tistory.com/trackback/82
	
//	Java Source File의 코드 순서
//
//	1. package선언 
//	2. improt구문
//	3. class 선언 및 구현 - file 하나에 class 여러개는 가능하지만 public class는 하나만 가능
//
//	class안에서 constructor, mothod, attribute 순서는 상관 없음. 
//	- 관례적으로 attribute, constructor, mothod 순으로 함.
	
//	입력 Class들
//
//	InputStream
//	- 1 byte 단위로 입력 받음
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
	

//	super
//	- 부모의 생성자 호출시 사용
//	- 생성자 구현부의 첫 명령어로 와야함 >> (this도 생성자 구현부의 첫 명령어로 와야하므로 super와 this는 같이 사용할 수 없다.)
//	- 생성자 구현부에 this()나 super()가 없으면 super();가 자동으로 들어감
//
//	예)
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
//	- 오류 이유 : 
//	Manager 클래스의 default생성자가 생성되면서 기본적으로 super()를 호출
//	Employee 클래스에 인자값을 받지 않는 생성자가 없으므로 오류가 남 
//
//	- 해결방법 : 
//	Employee 클래스에 인자값을 받지 않는 생성자를 추가


//	final의 역할
//	- 한번 정의 하면 더 이상 변화되지 않는 변수,메서드,class 앞에 붙여 변경을 막는 역할. 
//
//	적용 가능 위치
//	- 변수, 메서드(instance method), class
//
//	final의 위치에 따른 설명
//	메서드
//	- 하위 class에서 overriding을 할 수 없다.
//
//	class
//	- 하위 class를 가질 수 없다.
//
//	변수
//	- 변수의 상수화 ( 값이 설정되면 더이상 변경 불가능 ).
//	- instance 변수: 묵시적 초기화가 이루어지지 않음
//	- 값 대입 : 명시적 대입 (초기화) / 생성자에서 대입
//	- instance 변수에는 final을 잘 쓰지 않음. -> 주로 static과 같이 써서 class변수로 사용
//
//	static변수
//	- 선언시 값을 대입해 주어야 함.
//	- 값이 변할 일이 없으므로 주로 public 접근제한자를 붙여줌.
//
//	지역변수
//	- 초기화가 이루어지지 않기 때문에 사용 전에 대입.
//
//	final변수 이름 관례
//	- 모든 단어를 대문자로.
//	- 단어와 단어 사이를 _로 연결
//	- ex) final int MAX_SIZE = 15;
	 
//	abstract
//	- instance메서드, class에 사용되는 제한자
//	- 의미 : 추상적이다 -> 구현이 안 되었다.
//	- abstract method : 메서드 구현없이 선언한 메서드
//	- 사용 예) 
//	public abstract void go(); // {}이 붙으면 구현이 된 것이기 때문에 {}을 붙이면 안됨
//	 
//
//	- 하위 class에서의 overriding을 강요함. 
//	- 하위 class들이 구현할 메서드의 template(틀)을 제공하는 역할
//	- static과 함께 사용될 수 없다. 
//
//	- abstract class
//
//
//	- 역할 : 자식 class의 template, 자식 객체에 대한 Type역할.
//	- abstract class는 객체 생성을 할 수 없다.
//	- 사용 예) 
//
//	public abstract class Animal{
//	}
//	 
//
//	- abstract method가 포함된 class는 반드시 abstract class가 되어야 함.
//	- 부모 class에 정의 된 abstract 메서드를 overriding 하지 않으면 abstract class가 되어야 함.
//	- abstract class는 구현된 일반 메서드도 가질 수 있다.
//	- abstract class가 가질 수 있는 멤버
//
//	- 일반 class
//	- Field
//	- 생성자
//	- 메서드
//	- 추상 메서드
//
//
//	abstract의 UML표기
//	- italic체로 표기 
//
//	interface
//	- 완벽히 추상화된 구조
//	- 역할 : 
//
//	- 부모로서의 역할(자식 class에 대한 type과 template 제공을 위한 구조).
//	- program의 다른 class들에서 사용할 상수값(코드, 불변의 값) 선언시 사용
//	- 크게 관계 없는 class들을 하나의 type으로 묶을때 사용
//
//	- 사용 예)
//	public interface Interface { // [접근제한자] interface interface명 [extends/implements ...] { }
//	    public static final int a = 0; // public, static, final 생략가능
//	    public abstract void go(); // public, abstract 생략 가능 
//	}
//	 
//
//	- 여러 클래스의 공통적인 기능을 추상화 하여 기능을 선언만(기능 구현은 하지 않고) 해 놓은 것.
//	- Field로 static final 변수만 가질 수 있다.
//	- abstract class와 다르게 구현된 일반 메서드를 가질 수 없다.
//	- interface를 상속 받은 하위 클래스들은 반드시 interface에 선언된 메서드를 overriding해야 함. (메서드 기능이 구현 되어 있지 않기 때문에)
//	- interface는 객체 생성을 할 수 없다. (메서드 기능 구현을 하지 않기 때문에)
//	- class가 interface를 상속 받을 때 다중 상속이 가능하다(implement로 여러 interface를 받을 수 있다).
//
//
//	interface의 상속
//	- 사용 예)
//
//	public class SubClass implements Interface { // [접근제한자] class class명 implements interface명, .... { }
//	}
//	 
//	- class -> class : extends, 단일상속
//	- interface -> interface : extends, 다중상속
//	- class -> interface : implements, 다중상속
//
//
//	interface의 UML표기
//	- 
//
//	abstract class와 interface의 차이점
//	- abstract class는 구현된 method를 가질 수 있지만 interface는 구현된 method를 가질 수 없다.
//	- abstract class는 생성자를 가질 수 있지만 interface는 생성자를 가질 수 없다.
//	- abstract class는 자식 class에서 객체 생성시 부모객체도 생성이 되지만 interface는 부모객체가 생성되지 않는다 
//	   (interface는 생성자를 가지지 않기때문)
}


