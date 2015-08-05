package com.plate.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.plate.dao.model.ProvincesDAO;
import com.plate.model.Provinces;
import com.plate.util.hibernate.HibernateUtil;

/**
 * @author bruno ferrari
 *
 */
public class ProvincesDAOImpl implements Serializable, ProvincesDAO {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<Provinces> listProvinces() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Provinces> provinces = null;
		try {
			Query query = session.getNamedQuery("Provinces.list");
			provinces = query.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return provinces;
	}

	@Override
	public Provinces byId(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Provinces province = null;
		try{
			Query query = session.getNamedQuery("Provinces.byId");
			query.setLong("id", id);
			province = (Provinces) query.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return province;
	}
}
