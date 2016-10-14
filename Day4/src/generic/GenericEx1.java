package generic;

import java.1.ArrayList;

public class GenericEx1 {
	public static void main(String[] args) {
//		StudentDAO dao = new StudentDAO();
		DAO<Student> dao = new DAO<Student>(); // Generic
		
		dao.add(new Student("S001", "�̸۹�", 18));
		dao.add(new Student("S002", "������", 8));
		dao.add(new Student("S003", "�����̸�", 10));
		
//		for (Student s : dao.getAll()) {
//			s.displayInfo();
//		}
		 
		dao.printList();
		
		DAO<Employee> empDAO = new DAO<Employee>(); // Generic
		empDAO.add(new Employee("1001", "���Ѽ�"));
		empDAO.add(new Employee("1002", "������"));
		empDAO.add(new Employee("1003", "���Ŵ"));
		
//		for (Employee s : empDAO.getAll()) {
//			s.displayInfo();
//		}
		empDAO.printList();
		
		
	}
}


class DAO<T extends Displayable> { // Generic : compile�� Type�� check��. T�� Displayable�� ��� �� ���ų�(extends), �θ� �����.(super)
	private ArrayList<T> list = new ArrayList<T>(); // collection�� list���� �ϳ� ArrayList
	
	public void add(T s) {
		list.add(s);
	}
	
	public ArrayList<T> getAll() {
		return list;
	}
	
	public void printList() {
		for (T s : getAll()) {
			s.displayInfo();
		}
	}
}

interface Displayable {
	void displayInfo();
}

class Student implements Displayable {
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

class Employee implements Displayable {
	private String empNo;
	private String name;
	
	public Employee(String empNo, String name) {
		super();
		this.empNo = empNo;
		this.name = name;
	}
	
	public void displayInfo() {
		System.out.println("��� :"+empNo);
		System.out.println("�̸� :"+name);
		System.out.println();
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}