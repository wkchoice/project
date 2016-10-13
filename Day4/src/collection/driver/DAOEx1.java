package collection.driver;

import collection.dao.DAO;
import collection.dao.StudentDAO;
import collection.entity.Student;

public class DAOEx1 {
	public static void main(String[] args) {
//		StudentDAO dao = new StudentDAO(); // 
		DAO<Student> dao = new StudentDAO(); // generic이용.
		
		dao.add(new Student("S001", "이멍박", 18));
		dao.add(new Student("S002", "박은애", 8));
		dao.add(new Student("S003", "도라이몽", 10));
		
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
