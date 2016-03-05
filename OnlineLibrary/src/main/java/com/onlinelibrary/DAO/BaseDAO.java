package com.onlinelibrary.DAO;

import java.util.List;

public interface BaseDAO<T> {
	 public void save(T domain);  
	 public void update(T domain);         
	 public void delete(T domain);
	 public T get(Integer id);
	 public List<T> getAll();
}
