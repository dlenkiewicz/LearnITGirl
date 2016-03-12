package com.onlinelibrary.Test;

import com.onlinelibrary.DAO.UserDAOImpl;
import com.onlinelibrary.Model.User;

public class Test {

	public static void main(String[] args) {
		UserDAOImpl dao = new UserDAOImpl();
		
		// Add new user
        User user = new User();
        user.setName("Carl");
        user.setSurname("Smith");
        user.setEmail("carl.smith@gmail.com");
        user.setPassword("strongpsswd");
        dao.create(user);

        // Update user
        user.setEmail("carl.smith.updated@gmail.com");
        dao.update(user);

        // Delete user
        dao.delete(user.getId());

        // Get all users
        for (User iter : dao.getAll()) {
            System.out.println(iter);
        }

        // Get user by id
        System.out.println(dao.get(2));

		return;
	}
}
