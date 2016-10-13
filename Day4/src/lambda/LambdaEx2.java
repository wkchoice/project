package lambda;

import java.util.function.Predicate;

public class LambdaEx2 {
	public static void main(String[] args) {
		// lambda 식 : interface의 (argument(변수나 객체가 1개 인경우만 해당)를 위해 재정의함
		StudentDAO.displayFilteredList(s -> s.getAge() >= 18 );
	}
}

class StudentDAO {
	// 자바 interface는 약속이다. class(객체)가 할 수 있는것을 정의한 것이다.
    // 자식class에서 extends 대신 implements로 변경함.
//	interface FilterHandler {
//		boolean test(Student s);  // 아래의 Predicate로 대체 가능.( boolean인 경우에 한해서)
//	}

		
	static Student[] studentArr = {
		new Student("S001", "이멍박", 18),
		new Student("S002", "박은애", 8),
		new Student("S003", "도라이몽", 10),
		new Student("S004", "나학생", 25)
	};
	
//	public static void displayFilteredList(FilterHandler handler) {
	public static void displayFilteredList(Predicate<Student> handler) { // Predicate로 대체 가능
		for ( Student s : studentArr ) { // type선언 :  collector
			if (handler.test(s)) {
				s.displayInfo();
			}
		}
	}
}

class Student {
	private String studentNo;
	private String name;
	private int    age;
	
	public Student(String studentNo, String name, int age) {
		super();
		this.studentNo = studentNo;
		this.name = name;
		this.age = age;
	}

	public void displayInfo() {
		System.out.println("학번 :"+studentNo);
		System.out.println("이름 :"+name);
		System.out.println("나이 :"+age);
		System.out.println();
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}