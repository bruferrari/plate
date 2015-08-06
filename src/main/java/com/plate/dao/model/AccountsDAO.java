package com.plate.dao.model;

import java.util.List;

import com.plate.model.Accounts;
import com.plate.model.AccountsFilter;
import com.plate.model.Clients;
import com.plate.model.ClientsFilter;

public interface AccountsDAO {

	/**
	 * @return
	 */
	List<Accounts> listAll();
	
	/**
	 * @param client
	 */
	void delete(Accounts accounts);
	
	/**
	 * @param client
	 * @return
	 */
	Accounts saveOrUpdate(Accounts accounts);
	
	
	/**
	 * @param keyword
	 * @return
	 */
	List<Accounts> search(AccountsFilter filter);
	
	/**
	 * @param keyword
	 * @return
	 */
	
	Accounts findId(Long id);
}
