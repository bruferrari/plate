package com.plate.dao.model;

import java.util.List;

import com.plate.model.ProviderFilter;
import com.plate.model.Providers;

/**
 * @author bruno ferrari
 *
 */
public interface ProvidersDAO {

	/**
	 * @return
	 */
	List<Providers> listAll();
	
	/**
	 * @param provider
	 */
	void delete(Providers provider);
	
	/**
	 * @param provider
	 * @return
	 */
	Providers saveOrUpdate(Providers provider);
	
	/**
	 * @param filter
	 * @return
	 */
	List<Providers> search(ProviderFilter filter);
	
	/**
	 * @param filter
	 * @return
	 */
	List<Providers> searchByDoc(ProviderFilter filter);
}
