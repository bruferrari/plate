package com.plate.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.plate.dao.impl.AccountsDAOlmpl;
import com.plate.dao.impl.AccountsToPayDAOImpl;
import com.plate.dao.impl.BanksDAOImpl;
import com.plate.dao.impl.CategoriesDAOImpl;
import com.plate.model.Accounts;
import com.plate.model.AccountsFilter;
import com.plate.model.AccountsToPay;
import com.plate.model.AccountsToPayFilter;
import com.plate.model.Categories;
import com.plate.service.AccountsService;
import com.plate.service.AccountsToPayService;


@Named
@ViewScoped
public class AccountsToPayBean implements Serializable {


	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private AccountsToPayDAOImpl dao;
	
	@Inject
	private AccountsToPay accountsToPay;
	
	private List<AccountsToPay> accounts;
	private AccountsToPayFilter filter;
	private List<Categories> categories;
	private List<Accounts> accountsBank;
	
	private boolean repetir = false;
	  

	public boolean isRepetir() {
		return repetir;
	}

	public void setRepetir(boolean repetir) {
		this.repetir = repetir;
	}

	public AccountsToPayBean() {
		filter = new AccountsToPayFilter();
		accountsToPay = new AccountsToPay();
	}
	
	public void load(){
		AccountsDAOlmpl daoAcc = new AccountsDAOlmpl();
		CategoriesDAOImpl daoCat = new CategoriesDAOImpl();
		accountsBank = daoAcc.listAll();
		categories = daoCat.listAll();
	}
	
	public void save() {
		new AccountsToPayService().save(accountsToPay);
		accountsToPay = new AccountsToPay();
	}

	public AccountsToPayDAOImpl getDao() {
		return dao;
	}

	public void setDao(AccountsToPayDAOImpl dao) {
		this.dao = dao;
	}

	public AccountsToPay getAccountsToPay() {
		return accountsToPay;
	}

	public void setAccountsToPay(AccountsToPay accountsToPay) {
		this.accountsToPay = accountsToPay;
	}

	public List<AccountsToPay> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountsToPay> accounts) {
		this.accounts = accounts;
	}

	public AccountsToPayFilter getFilter() {
		return filter;
	}

	public void setFilter(AccountsToPayFilter filter) {
		this.filter = filter;
	}

	public List<Categories> getCategories() {
		return categories;
	}

	public void setCategories(List<Categories> categories) {
		this.categories = categories;
	}

	public List<Accounts> getAccountsBank() {
		return accountsBank;
	}

	public void setAccountsBank(List<Accounts> accountsBank) {
		this.accountsBank = accountsBank;
	}
	
	

	
}
