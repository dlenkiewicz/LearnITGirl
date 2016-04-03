package com.onlinelibrary.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.onlinelibrary.Model.Book;
import com.onlinelibrary.Util.HibernateUtil;

public class BookDAOImpl extends BaseDAOImpl<Book>{
	public Book get(String isbn) {
		Book domain = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String queryString = "from " + getEntityBeanType().getName() + " where isbn = :isbn";
            Query query = session.createQuery(queryString);
			query.setString("isbn", isbn);
            domain = (Book) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return domain;
	}
	
	public void delete(String isbn) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Book domain = get(isbn);
            session.delete(domain);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
}
