package com.onlinelibrary.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.onlinelibrary.Model.User;
import com.onlinelibrary.Util.HibernateUtil;

public class UserDAOImpl extends BaseDAOImpl<User>{
	
	public User getByEmail(String email) {
		User domain = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String queryString = "from " + getEntityBeanType().getName() + " where email = :email";
            Query query = session.createQuery(queryString);
            query.setString("email", email);
            domain = (User) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return domain;
	}
}
