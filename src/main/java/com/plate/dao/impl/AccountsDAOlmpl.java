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
import com.plate.dao.model.AccountsDAO;
import com.plate.model.Accounts;
import com.plate.model.AccountsFilter;
import com.plate.model.Categories;
import com.plate.model.Clients;
import com.plate.util.hibernate.HibernateUtil;

public class AccountsDAOlmpl implements AccountsDAO, Serializable {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<Accounts> listAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Accounts> accounts = null;

		try {
			Query query = session.getNamedQuery("Accounts.list");
			accounts = query.list();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}

		return accounts;
	}

	@Override
	public void delete(Accounts account) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.delete(account);
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
	public Accounts saveOrUpdate(Accounts account) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(account);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null) {
				tx.rollback();
			}
			throw ex;
		} finally {
			session.close();
		}
		return account;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Accounts> search(AccountsFilter filter) {
		List<Accounts> accounts = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Accounts.class);
		try {
			if (StringUtils.isNotBlank(filter.getName())) {
				criteria.add(Restrictions.ilike("description", filter.getName(),
						MatchMode.ANYWHERE));
				accounts = criteria.list();
			}
			return criteria.addOrder(Order.asc("description")).list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close(); 
		}
	}
	
	@Override
	public Accounts findId(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		// Recebe o resultado da conculta
		Accounts accounts = null;
		try {
			Query consulta = session
					.getNamedQuery("Accounts.findId");
			consulta.setLong("id", id);
			accounts = (Accounts) consulta.uniqueResult(); // CAST: converte
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}
		return accounts;
	}

}
