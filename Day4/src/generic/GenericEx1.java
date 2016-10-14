package generic;

import java.1.ArrayList;

public class GenericEx1 {
	public static void main(String[] args) {
//		StudentDAO dao = new StudentDAO();
		DAO<Student> dao = new DAO<Student>(); // Generic
		
		dao.add(new Student("S001", "이멍박", 18));
		dao.add(new Student("S002", "박은애", 8));
		dao.add(new Student("S003", "도라이몽", 10));
		
//		for (Student s : dao.getAll()) {
//			s.displayInfo();
//		}
		 
		dao.printList();
		
		DAO<Employee> empDAO = new DAO<Employee>(); // Generic
		empDAO.add(new Employee("1001", "묘한손"));
		empDAO.add(new Employee("1002", "에락손"));
		empDAO.add(new Employee("1003", "장앤킴"));
		
//		for (Employee s : empDAO.getAll()) {
//			s.displayInfo();
//		}
		empDAO.printList();
		
		
	}
}


class DAO<T extends Displayable> { // Generic : compile시 Type을 check함. T는 Displayable는 상속 및 같거나(extends), 부모만 상속함.(super)
	private ArrayList<T> list = new ArrayList<T>(); // collection의 list중의 하나 ArrayList
	
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

class Employee implements Displayable {
	private String empNo;
	private String name;
	
	public Employee(String empNo, String name) {
		super();
		this.empNo = empNo;
		this.name = name;
	}
	
	public void displayInfo() {
		System.out.println("사번 :"+empNo);
		System.out.println("이름 :"+name);
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