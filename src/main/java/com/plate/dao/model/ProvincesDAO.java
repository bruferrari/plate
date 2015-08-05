package com.plate.dao.model;

import java.util.List;

import com.plate.model.Provinces;

/**
 * @author bruno ferrari
 *
 */
public interface ProvincesDAO {

	/**
	 * @return
	 */
	List<Provinces> listProvinces();
	
	/**
	 * @param id
	 * @return
	 */
	Provinces byId(Long id);
}
