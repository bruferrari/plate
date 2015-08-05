package com.plate.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.plate.dao.model.CitiesDAO;
import com.plate.model.Cities;
import com.plate.util.hibernate.HibernateUtil;

/**
 * @author bruno ferrari
 *
 */

public class CitiesDAOImpl implements Serializable, CitiesDAO {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<Cities> list(Long provinceId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Cities> cities = null;
		
		try{
			Query query = session.getNamedQuery("Cities.list");
			query.setLong("province", provinceId);
			cities = query.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return cities;
	}

	@Override
	public Cities byId(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Cities city = null;
		try {
			Query query = session.getNamedQuery("Cities.byId");
			query.setLong("id", id);
			city = (Cities) query.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}
		return city;
	}

}
