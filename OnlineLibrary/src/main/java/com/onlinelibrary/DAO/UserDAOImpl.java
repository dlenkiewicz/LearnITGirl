package com.onlinelibrary.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.onlinelibrary.Model.User;

public class UserDAOImpl implements UserDAO{
	
	private SessionFactory sessionFactory;
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void save(User user) {
		getCurrentSession().save(user);
	}

	@Override
	public void update(User user) {
		User userToUpdate = get(user.getId());
		userToUpdate.setName(user.getName());
		userToUpdate.setSurname(user.getSurname());
		userToUpdate.setCity(user.getCity());
		userToUpdate.setStreetAddress(user.getStreetAddress());
		userToUpdate.setEmail(user.getCity());
		userToUpdate.setPhoneNumber(user.getPhoneNumber());
		getCurrentSession().update(userToUpdate);
	}

	@Override
	public void delete(User user) {
		getCurrentSession().delete(user);
	}

	@Override
	public User get(Integer id) {
		User user = (User) getCurrentSession().get(User.class, id);
		return user;
	}

	@Override
	public List<User> getAll() {
		return getCurrentSession().createQuery("from User").list();
	}
}
