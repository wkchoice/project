package db.dao;

import java.util.List;

public interface DAO<T> { // class���� ��, interface�� ����
	
	T get(String key); // �� �� ��ȸ.
	List<T> getAll(); // ��� ��ȸ. (list�̿�)
	boolean Insert(T t); 
	boolean Update(T t);
	boolean Delete(String key); // ���ڳ� ���ڰ� ��� ������ string���.
}


