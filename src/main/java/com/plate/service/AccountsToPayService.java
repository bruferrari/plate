package com.plate.service;

import java.io.Serializable;
import java.util.List;

import com.plate.dao.impl.AccountsDAOlmpl;
import com.plate.dao.impl.AccountsToPayDAOImpl;
import com.plate.dao.model.AccountsDAO;
import com.plate.dao.model.AccountsToPayDAO;
import com.plate.model.Accounts;
import com.plate.model.AccountsToPay;
import com.plate.util.jsf.JSFUtil;

public class AccountsToPayService implements Serializable {


	private static final long serialVersionUID = 1L;
		
	
	public List<AccountsToPay> listAll() {
		AccountsToPayDAO dao = new AccountsToPayDAOImpl();
		List<AccountsToPay> accountsToPay = dao.listAll();
		return accountsToPay;
	}
	
	public void save(AccountsToPay accounts) {
		AccountsToPayDAO dao = new AccountsToPayDAOImpl();

		try {
			dao.saveOrUpdate(accounts);
			JSFUtil.addSuccessMessage("Conta a Pagar inserida com sucesso!");
		} catch (Exception e) {
			JSFUtil.addErrorMessage("Ocorreu um erro ao tentar inserir a conta a pagar"
					+ "Por favor contate o administrador do sistema");
		}
	}
	

}
