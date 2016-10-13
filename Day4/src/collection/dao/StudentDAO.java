package collection.dao;

import java.util.ArrayList;
import java.util.List;

import collection.entity.Student;
import collection.dao.DAO;

public class StudentDAO implements DAO<Student> { // interface and generic이용.
	private ArrayList<Student> list = new ArrayList<Student>();
	
	// 추가
	public void add(Student s) {
		list.add(s);
	}
	
	// 수정
	public void edit(Student s) {
		Student stu = get(s.getStudentNo());
		if (stu != null) {
			stu.setName(s.getName());
			stu.setAge(s.getAge());
		}
		else
			System.out.println("찾을수 없음");
	}
	
	// 삭제
	public void remove(String studentNo) {
		Student s = get(studentNo);
		if (s != null)
			list.remove(s);
		else
			System.out.println("찾을 수 없음.");
	}
	
	// 객체 하나 조회
	public Student get(String studentNo) {
		for (Student s : list) {
			if (s.getStudentNo().equals(studentNo)) {
				return s;
			}
		}
		 return null;
	}
	
	// 객체 전체 조회
	public List<Student> getAll() { // interface이용
		return list;
	}
}
