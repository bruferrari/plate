package com.plate.service;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.plate.dao.impl.ProvincesDAOImpl;
import com.plate.dao.model.ProvincesDAO;
import com.plate.model.Provinces;

/**
 * @author bruno ferrari
 *
 */
public class ProvincesService implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ProvincesService.class.toString());
	

	public List<Provinces> listAll() {
		ProvincesDAO dao = new ProvincesDAOImpl();
		List<Provinces> provinces = dao.listProvinces();
		
		if(logger.isDebugEnabled()){
			logger.debug("listProvinces - BEGIN");
			logger.debug("result: " + provinces);
			logger.debug("listProvinces - END");
		}
		
		return provinces;
	}
}
