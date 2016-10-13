package collection.driver;

import collection.dao.DAO;
import collection.dao.StudentDAO;
import collection.entity.Student;

public class DAOEx1 {
	public static void main(String[] args) {
//		StudentDAO dao = new StudentDAO(); // 
		DAO<Student> dao = new StudentDAO(); // generic�̿�.
		
		dao.add(new Student("S001", "�̸۹�", 18));
		dao.add(new Student("S002", "������", 8));
		dao.add(new Student("S003", "�����̸�", 10));
		
		//
		dao.get("S002").displayInfo();
		Student  s1 = dao.get("S002");
		
		s1.setAge(9);
		dao.edit(s1);
		
		dao.get("S002").displayInfo();

		//
		dao.remove("S002");
		
		System.out.println("--------------------------------");
		
		for (Student s : dao.getAll()) {
			s.displayInfo();
		}
		
	}
}
