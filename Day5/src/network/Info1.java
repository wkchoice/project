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
//	- 역할 : 자식 class의 template, 자식 객체에 대한 Type역할.
//	- abstract class는 객체 생성을 할 수 없다.
//	- 사용 예) 
//
//	public abstract class Animal{
//	}
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
//	- 여러 클래스의 공통적인 기능을 추상화 하여 기능을 선언만(기능 구현은 하지 않고) 해 놓은 것.
//	- Field로 static final 변수만 가질 수 있다.
//	- abstract class와 다르게 구현된 일반 메서드를 가질 수 없다.
//	- interface를 상속 받은 하위 클래스들은 반드시 interface에 선언된 메서드를 overriding해야 함. (메서드 기능이 구현 되어 있지 않기 때문에)
//	- interface는 객체 생성을 할 수 없다. (메서드 기능 구현을 하지 않기 때문에)
//	- class가 interface를 상속 받을 때 다중 상속이 가능하다(implement로 여러 interface를 받을 수 있다).
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
//	interface의 UML표기
//	- 
//	abstract class와 interface의 차이점
//	- abstract class는 구현된 method를 가질 수 있지만 interface는 구현된 method를 가질 수 없다.
//	- abstract class는 생성자를 가질 수 있지만 interface는 생성자를 가질 수 없다.
//	- abstract class는 자식 class에서 객체 생성시 부모객체도 생성이 되지만 interface는 부모객체가 생성되지 않는다 
//	   (interface는 생성자를 가지지 않기때문)
	
//	
//	Collection API
//	- Data들을 모아 관리하는 객체들
//	- 모으는 방법에 따라 여러 class로 제공
//	- Object type 형식으로 구성되어 있어서 어떤 Data든 상관없이 모을 수 있다
//	
//	Collection
//	- 값을 모아 관리하는 것
//
//	Map
//	- Key - Value 쌍
//	- Key를 이용하여 Value를 찾는 형식
//
//	배열과 Collection의 차이
//	- 배열 : 크기가 한번 정해지면 변경할 수 없다.
//	- Collection : 크기를 넘어갈 경우 스스로 크기를 늘리는 작업을 수행해준다.
//
//	Collection의 메서드들
//	- 추가 : boolean add(Object) // 성공하면 true, 실패하면 false
//	- 삭제 : boolean remove(Object) // 성공하면 true, 실패하면 false
//	- 조회 : X -> Iterator iterator() 
//	- 크기 : int size() // 관리하는 객체의 수를 return
//	- 확인 : boolean contains(Object) // 인자로 받은 객체가 collection안에 있는지 확인 후 boolean을 return
//	- 초기화 : clear() // 컬렉션 내의 모든 객체를 삭제 (size도 0으로 초기화)
	
//	List의 특징
//	- 중간 index에 null이 있으면 오류발생
//
//	Vector
//	- 멀티 Thread환경에서 Performance는 떨어지지만 안정성이 좋다
//
//	ArrayList
//	- 전체적으로 배열과 비슷하지만 배열보다 데이터의 추가와 삭제가 편리하게 구성한 것
//	- 멀티 Thread환경에서 안정성이 떨어지지만 Performance가 좋다
//	- 떨어지는 안정성을 Code로 보완이 가능
//
//	LinkedList
//	- Data와 Data사이를 연결하여 데이터의 추가, 삭제가 편리하게 구성된 것
//
//	List의 메서드들
//	- 삽입 : add(int index, Object) // index에 Object를 삽입 ( 4번에 A, 5번에 B라는 데이터가 있을때 add(5, C)를 하면 A, C, B 순으로 됨 )
//	- 교체 : set(int index, Object) // 해당 index의 값을 Object로 변경
//	- 삭제 : Object remove(int index) // 해당 index의 객체를 삭제하고 해당 객체를 return
//	- 조회 : Object get(int index) // 해당 index의 객체를 return
//	            int indexOf(Object) // 해당 Object가 있는 index를 return (0번 index부터 검색)
//	            int lastIndexOf(Object) // 해당 Object가 있는 index를 return (마지막 index부터 검색)

//	generic
//
//			- class에서 사용할 type을 class 작성시 지정하는 것이 아니라 사용시점에 지정하는 것.
//			- static 메서드에는 사용 불가능
//			- 생략이 가능하며 생략할 경우 모든 자료형(Object Type)을 넣을 수 있다.
//			- 설정할 경우 return type과 매개변수 type이 generic 표기법으로 설정한 Class Type으로 설정된다.
//
//			generic의 선언과 사용?
//			- 선언 
//			public class ClassName<E> {
//			    modifier returnType methodName(E e) {
//			    }
//			}
//			 
//			- 사용 
//			ClassName<TYPE> instanceName = new ClassName<TYPE>();
//			 
//			generic을 사용하는 이유?
//			- return type을 맞춰줘서 casting 오류를 범하지 않도록 유도하기 위해
//			- Collection API들의 값(또는 key)의 자료형(ClassType)을 통일시키기 위해 이용.

//	Object class?
//			- Java에 존재하는 / 추가될 모든 class의 최상위 class 
//			- 모든 객체의 Type이 될 수 있다. (다형성)
//
//			Object class의 methods
//			- toString() : String 
//
//			객체를 String으로 변환
//			하위 class에서 Overriding해서 이용하는게 주 목적 (객체의 Attribute의 값들은 String으로 변환)
//
//			- equals(Object obj) : boolean
//
//			매개변수로 받은 객체가 같은 객체인지 비교
//			하위 class에서 Overriding해서 이용하는게 주 목적 (두 객체의 Attribute의 값이 같은지 비교)
//
//			- overriding 방법 : 매개변수가 null이 아니고 class가 같고 attribute의 값들이 같은지 비교
//
//			*equals() 메서드를 overriding 할때 반드시 hashCode() 메서드도 같이 overriding 해야함
//
//			- hashCode() : int
//
//			가상의 주소값을 return해주는 method
//
//			- finalize()
//
//			JVM의 GarbageCollector가 객체의 메모리를 해제할 때 호출하는 method
	
//	java.lang.Class
//	- class의 정보를 처리하는 객체
//
//	Class 정보를 가져오는 방법
//	- Object class의 [getClass() : Class] method 호출
//	 
//	Class c = obj.getClass()
//
//	- Class이름.class를 이용하여 Class객체를 return
//	 
//	Class c = ProductDTO.class
//	 
//	- Class.forName("Class의 fullyName")을 호출
//	 
//	Class c = Class.forName("dto.ProductDTO")
//	 

}


