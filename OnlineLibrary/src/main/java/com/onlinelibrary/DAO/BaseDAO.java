package com.onlinelibrary.DAO;

import java.util.List;

public interface BaseDAO<T> {
	 public void create(T domain);  
	 public void update(T domain);         
	 public void delete(int id);
	 public T get(Integer id);
	 public List<T> getAll();
}
