package collection.dao;

import java.util.ArrayList;
import java.util.List;

import collection.entity.Student;
import collection.dao.DAO;

public class StudentDAO implements DAO<Student> { // interface and generic�̿�.
	private ArrayList<Student> list = new ArrayList<Student>();
	
	// �߰�
	public void add(Student s) {
		list.add(s);
	}
	
	// ����
	public void edit(Student s) {
		Student stu = get(s.getStudentNo());
		if (stu != null) {
			stu.setName(s.getName());
			stu.setAge(s.getAge());
		}
		else
			System.out.println("ã���� ����");
	}
	
	// ����
	public void remove(String studentNo) {
		Student s = get(studentNo);
		if (s != null)
			list.remove(s);
		else
			System.out.println("ã�� �� ����.");
	}
	
	// ��ü �ϳ� ��ȸ
	public Student get(String studentNo) {
		for (Student s : list) {
			if (s.getStudentNo().equals(studentNo)) {
				return s;
			}
		}
		 return null;
	}
	
	// ��ü ��ü ��ȸ
	public List<Student> getAll() { // interface�̿�
		return list;
	}
}
