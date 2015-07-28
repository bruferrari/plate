package com.plate.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.plate.dao.model.CategoriesDAO;
import com.plate.model.Categories;
import com.plate.util.hibernate.HibernateUtil;
import com.plate.util.jsf.JSFUtil;

/**
 * @author bruno ferrari
 *
 */
public class CategoriesDAOImpl implements CategoriesDAO, Serializable {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<Categories> listAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Categories> categories = null;
		
		try{
			Query query = session.getNamedQuery("Categories.list");
			categories = query.list();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}
		
		return categories;
	}

	@Override
	public void delete(Categories category) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.delete(category);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
		
	}

	@Override
	public Categories saveOrUpdateCategory(Categories category) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			session.saveOrUpdate(category);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}
		return category;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categories> search(String keyword) {
		List<Categories> categories = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			Criteria criteria = session.createCriteria(Categories.class);
			criteria.add(Restrictions.ilike("description", keyword, MatchMode.ANYWHERE));
			categories = criteria.list();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}
		return categories;
	}


}
