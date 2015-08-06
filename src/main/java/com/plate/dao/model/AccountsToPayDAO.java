package com.plate.dao.model;

import java.util.List;

import com.plate.model.AccountsToPay;
import com.plate.model.AccountsToPayFilter;

public interface AccountsToPayDAO {
			
	
	/**
	 * @return
	 */
	List<AccountsToPay> listAll();
	
	/**
	 * @param client
	 */
	void delete(AccountsToPay accountsToPay);
	
	/**
	 * @param client
	 * @return
	 */
	AccountsToPay saveOrUpdate(AccountsToPay accountsToPay);
	
	
	/**
	 * @param keyword
	 * @return
	 */
	List<AccountsToPay> search(AccountsToPayFilter filter);
	
	/**
	 * @param keyword
	 * @return
	 */
	
	AccountsToPay findId(Long id);
}
