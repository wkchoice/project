package db.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import db.DBUtil;
import db.entity.Department;

public class DepartmentDAO implements DAO<Department> {

	@Override
	public Department get(String key) {
		Department dept = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection con = DBUtil.getConnection();
		String sql = "SELECT * FROM departments WHERE department_id = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, key);
			rs = stmt.executeQuery(); // SELECT�� �����Ҷ�, ����� ResultSet���� ����
			
			if (rs.next()) {
				// ���ǿ� �´� ���ڵ尡 �����ϴ� ���
				dept = new Department();
				dept.setId(rs.getInt("department_id"));
				dept.setName(rs.getString("member_name"));
				dept.setManager_id(rs.getInt("manager_id"));
				dept.setLocation_id(rs.getInt("location_id"));
			}
		} catch (SQLException e) { }
		
		DBUtil.Close(stmt, rs);
		
		return dept;
	}

	@Override
	public List<Department> getAll() {
		List<Department> list = new ArrayList<Department>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection con = DBUtil.getConnection();
		String sql = "SELECT * FROM departments";
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				// ���ǿ� �´� ���ڵ尡 �����ϴ� ���
				Department dept = new Department();
				dept.setId(rs.getInt("department_id"));
				dept.setName(rs.getString("member_name"));
				dept.setManager_id(rs.getInt("manager_id"));
				dept.setLocation_id(rs.getInt("location_id"));
				
				list.add(dept);
			}
		} catch (SQLException e) {
			e.getStackTrace();
		}
		
		DBUtil.Close(stmt, rs);
		
		return list;
	}

	@Override
	public boolean Insert(Department t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Update(Department t) {
		Connection con = null;
		PreparedStatement stmt = null;
		String sql ="UPDATE departments SET department_name = ?, manager_id = ?, location_id = ? WHERE department_id = ?";
		
		con = DBUtil.getConnection();
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1,  t.getName());
			stmt.setInt(2, t.getManager_id());
			stmt.setInt(3, t.getLocation_id());
			stmt.setInt(4, t.getId());
			
			stmt.executeUpdate(); // INSERT�� DDL�� �����Ҷ�, �������γ� ������ ������ ����.
			return true;
			
		} catch (SQLException e) {
			return false;
		}
		finally {
			DBUtil.Close(stmt);
		}
	}

	@Override
	public boolean Delete(String key) {
		// TODO Auto-generated method stub
		return false;
	}

}
