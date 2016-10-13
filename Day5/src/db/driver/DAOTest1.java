package db.driver;

import java.util.List;

import db.dao.DepartmentDAO;
import db.entity.Department;

public class DAOTest1 {
	public static void main(String[] args) {
		List<Department> all= new DepartmentDAO().getAll();
		
		System.out.println("ºÎ¼­ ¼ö : "+all.size());
	}
}
