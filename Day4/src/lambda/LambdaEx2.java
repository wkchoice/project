package lambda;

import java.util.function.Predicate;

public class LambdaEx2 {
	public static void main(String[] args) {
		// lambda �� : interface�� (argument(������ ��ü�� 1�� �ΰ�츸 �ش�)�� ���� ��������
		StudentDAO.displayFilteredList(s -> s.getAge() >= 18 );
	}
}

class StudentDAO {
	// �ڹ� interface�� ����̴�. class(��ü)�� �� �� �ִ°��� ������ ���̴�.
    // �ڽ�class���� extends ��� implements�� ������.
//	interface FilterHandler {
//		boolean test(Student s);  // �Ʒ��� Predicate�� ��ü ����.( boolean�� ��쿡 ���ؼ�)
//	}

		
	static Student[] studentArr = {
		new Student("S001", "�̸۹�", 18),
		new Student("S002", "������", 8),
		new Student("S003", "�����̸�", 10),
		new Student("S004", "���л�", 25)
	};
	
//	public static void displayFilteredList(FilterHandler handler) {
	public static void displayFilteredList(Predicate<Student> handler) { // Predicate�� ��ü ����
		for ( Student s : studentArr ) { // type���� :  collector
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
		System.out.println("�й� :"+studentNo);
		System.out.println("�̸� :"+name);
		System.out.println("���� :"+age);
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