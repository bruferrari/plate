package com.plate.service;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.plate.dao.impl.CitiesDAOImpl;
import com.plate.dao.model.CitiesDAO;
import com.plate.model.Cities;

/**
 * @author bruno ferrari
 *
 */
public class CitiesService implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(CitiesService.class.toString());
	

	public List<Cities> listAll(Long provinceId) {
		CitiesDAO dao = new CitiesDAOImpl();
		List<Cities> cities = dao.list(provinceId);
		if(logger.isDebugEnabled()){
			logger.debug("listCities - BEGIN");
			logger.debug("result: " + cities);
			logger.debug("listCities - END");
		}
		return cities;
	}
}
