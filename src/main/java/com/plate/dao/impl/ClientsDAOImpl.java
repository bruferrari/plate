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

import com.plate.dao.model.ClientsDAO;
import com.plate.model.Clients;
import com.plate.model.ClientsFilter;
import com.plate.util.hibernate.HibernateUtil;

public class ClientsDAOImpl implements ClientsDAO, Serializable {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<Clients> listAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Clients> clients = null;
		
		try {
			Query query = session.getNamedQuery("Clients.list");
			clients = query.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return clients;
	}

	@Override
	public void delete(Clients client) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.delete(client);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null) {
				tx.rollback();
			}
			throw ex;
		} finally {
			session.close();
		}
		
	}

	@Override
	public Clients saveOrUpdate(Clients client) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(client);
			tx.commit();
		} catch (RuntimeException ex) {
			if(tx != null) {
				tx.rollback();
			}
			throw ex;
		} finally {
			session.close();
		}
		return client;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Clients> search(ClientsFilter filter) {
		List<Clients> clients = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Clients.class);
		try {
			if (StringUtils.isNotBlank(filter.getNome())) {
				criteria.add(Restrictions.ilike("name", filter.getNome(), MatchMode.ANYWHERE));
				clients = criteria.list();
			}
			return criteria.addOrder(Order.asc("name")).list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
	}

}
