package db.dao;

import java.util.List;

public interface DAO<T> { // class생성 후, interface로 변경
	
	T get(String key); // 한 건 조회.
	List<T> getAll(); // 모두 조회. (list이용)
	boolean Insert(T t); 
	boolean Update(T t);
	boolean Delete(String key); // 숫자나 문자가 모두 가능한 string사용.
}


