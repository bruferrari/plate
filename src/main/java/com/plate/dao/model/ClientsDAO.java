package com.plate.dao.model;

import java.util.List;

import com.plate.model.Clients;

/**
 * @author bruno ferrari
 *
 */
public interface ClientsDAO {

	/**
	 * @return
	 */
	List<Clients> listAll();
	
	/**
	 * @param client
	 */
	void delete(Clients client);
	
	/**
	 * @param client
	 * @return
	 */
	Clients saveOrUpdate(Clients client);
	
	
	/**
	 * @param keyword
	 * @return
	 */
	List<Clients> search(String keyword);
}
