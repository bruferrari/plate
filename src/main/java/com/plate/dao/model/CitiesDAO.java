package com.plate.dao.model;

import java.util.List;

import com.plate.model.Cities;

/**
 * @author bruno ferrari
 *
 */
public interface CitiesDAO {
	
	/**
	 * @return
	 */
	List<Cities> list(Long provinceId);
	
	/**
	 * @param id
	 * @return
	 */
	Cities byId(Long id);
}
