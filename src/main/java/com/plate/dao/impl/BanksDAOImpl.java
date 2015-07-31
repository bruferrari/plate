package com.plate.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.plate.dao.model.BanksDAO;
import com.plate.model.Banks;
import com.plate.model.Clients;
import com.plate.util.hibernate.HibernateUtil;

public class BanksDAOImpl implements BanksDAO, Serializable {


	private static final long serialVersionUID = 1L;

	@Override
	public Banks findId(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		// Recebe o resultado da conculta
		Banks banks = null;
		try {
			Query consulta = session.getNamedQuery("Banks.findId");
			consulta.setLong("id", id);
			banks = (Banks) consulta.uniqueResult(); // CAST: converte
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}
		return banks;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Banks> listAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Banks> banks = null;
		
		try {
			Query query = session.getNamedQuery("Banks.list");
			banks = query.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return banks;
	}

}
