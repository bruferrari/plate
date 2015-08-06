package com.plate.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.plate.dao.model.AccountsToPayDAO;
import com.plate.model.Accounts;
import com.plate.model.AccountsToPay;
import com.plate.model.AccountsToPayFilter;
import com.plate.util.hibernate.HibernateUtil;

public class AccountsToPayDAOImpl implements AccountsToPayDAO, Serializable{


	private static final long serialVersionUID = 1L;

	@Override
	public List<AccountsToPay> listAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<AccountsToPay> accountsToPay = null;

		try {
			Query query = session.getNamedQuery("AccountsToPay.list");
			accountsToPay = query.list();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}

		return accountsToPay;
	}

	@Override
	public void delete(AccountsToPay accountsToPay) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AccountsToPay saveOrUpdate(AccountsToPay accountsToPay) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(accountsToPay);
			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null) {
				tx.rollback();
			}
			throw ex;
		} finally {
			session.close();
		}
		return accountsToPay;
	}

	@Override
	public List<AccountsToPay> search(AccountsToPayFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountsToPay findId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
