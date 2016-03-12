package com.onlinelibrary.DAO;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.onlinelibrary.Util.HibernateUtil;

public abstract class BaseDAOImpl<T> implements BaseDAO<T>{
	private Class entityBeanType;
	
	@SuppressWarnings("unchecked")
	  public BaseDAOImpl(){
	    this.entityBeanType = ((Class) ((ParameterizedType) getClass()
	            .getGenericSuperclass()).getActualTypeArguments()[0]);
	    }
	
	protected Class getEntityBeanType() {
		return entityBeanType;
		}

	public void create(T domain) {
		Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(domain);
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

	public void update(T domain) {
		Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(domain);
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

	public void delete(int id) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            T domain = get(id);
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

	public T get(Integer id) {
		T domain = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from " + getEntityBeanType().getName() + " where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            domain = (T) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return domain;
	}

	public List<T> getAll() {
		List<T> domains = new ArrayList<T>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            domains = session.createQuery("from " + getEntityBeanType().getName()).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return domains;
	}
}
