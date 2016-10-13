package collection.dao;

import java.util.List;

public interface DAO<T> {
	void add(T t);
	void edit(T t);
	void remove(String key);
	
	T get(String key);
	List<T> getAll();

}
