package com.plate.service;

import java.io.Serializable;
import java.util.List;

import com.plate.dao.impl.AccountsDAOlmpl;
import com.plate.dao.model.AccountsDAO;
import com.plate.model.Accounts;
import com.plate.model.AccountsFilter;
import com.plate.util.jsf.JSFUtil;

public class AccountsService implements Serializable {

	private static final long serialVersionUID = 1L;

	public List<Accounts> listAll() {
		AccountsDAO dao = new AccountsDAOlmpl();
		List<Accounts> accounts = dao.listAll();
		return accounts;
	}

	public void delete(Accounts accounts) {
		AccountsDAO dao = new AccountsDAOlmpl();
		try {
			dao.delete(accounts);
			JSFUtil.addSuccessMessage("Conta " + accounts.getDescription()
					+ " deletada com sucesso.");
		} catch (RuntimeException e) {
			JSFUtil.addErrorMessage("Ocorreu um erro ao tentar deletar a conta"
					+ accounts.getDescription());
		}
	}

	public void save(Accounts accounts) {
		AccountsDAO dao = new AccountsDAOlmpl();

		try {
			dao.saveOrUpdate(accounts);
			JSFUtil.addSuccessMessage("Conta inserida com sucesso!");
		} catch (Exception e) {
			JSFUtil.addErrorMessage("Ocorreu um erro ao tentar inserir a conta"
					+ "Por favor contate o administrador do sistema");
		}
	}
	
	public void update(Accounts accounts) {
		AccountsDAO dao = new AccountsDAOlmpl();
		
		try{
			dao.saveOrUpdate(accounts);
			JSFUtil.addSuccessMessage("Conta alterada com sucesso!");
		} catch (Exception e) {
			JSFUtil.addErrorMessage("Ocorreu um erro ao tentar alterar a conta."
					+ " Por favor contate o administrador do sistema.");
			
		}
	}
	
	public List<Accounts> search(AccountsFilter filter) {
		AccountsDAO dao = new AccountsDAOlmpl();
		List<Accounts> accounts = null;
		
		try{
			accounts = dao.search(filter);
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.addErrorMessage("Ocorreu um erro ao tentar efetuar a pesquisa."
					+ " Por favor contate o administrador do sistema.");
		}
		return accounts;
	}

}
