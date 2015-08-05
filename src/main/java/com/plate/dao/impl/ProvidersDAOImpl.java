package com.plate.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.plate.dao.model.ProvidersDAO;
import com.plate.model.ProviderFilter;
import com.plate.model.Providers;
import com.plate.model.Provinces;
import com.plate.util.hibernate.HibernateUtil;

/**
 * @author bruno ferrari
 *
 */
public class ProvidersDAOImpl implements ProvidersDAO, Serializable {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<Providers> listAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Providers> providers = null;
		
		try{
			Query query = session.getNamedQuery("Providers.list");
			providers = query.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return providers;
	}

	@Override
	public void delete(Providers provider) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		try{
			session.delete(provider);
			tx.commit();
		} catch (RuntimeException ex) {
			if(tx != null)
				tx.rollback();
			throw ex;
		} finally {
			session.close();
		}
	}

	@Override
	public Providers saveOrUpdate(Providers provider) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		try{
			session.saveOrUpdate(provider);
			tx.commit();
		} catch (RuntimeException ex) {
			if(tx != null)
				tx.rollback();
			throw ex;
		} finally {
			session.close();
		}
		return provider;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Providers> search(ProviderFilter filter) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Providers> providers = null;
		Criteria criteria = session.createCriteria(Providers.class);
		try{
			if(StringUtils.isNotBlank(filter.getName())) {
				criteria.add(Restrictions.ilike("name", filter.getName(), MatchMode.ANYWHERE));
				providers = criteria.list();
			}
			return criteria.addOrder(Order.asc("name")).list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
	}
	
	/**
	 * @param id
	 * @return
	 */
	public Providers byId(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Providers provider = null;
		try {
			Query query = session.getNamedQuery("Providers.byId");
			query.setLong("id", id);
			provider = (Providers) query.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return provider;
	}
	

	@SuppressWarnings({ "unused", "unchecked" })
	@Override
	public List<Providers> searchByDoc(ProviderFilter filter) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Providers> providers = null;
		Criteria criteria = session.createCriteria(Providers.class);
		try{
			if(StringUtils.isNotBlank(filter.getName())) {
				criteria.add(Restrictions.ilike("doc", filter.getDoc(), MatchMode.ANYWHERE));
				providers = criteria.list();
			}
			return criteria.addOrder(Order.asc("name")).list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
	}
}
