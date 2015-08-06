package com.plate.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.plate.dao.impl.AccountsDAOlmpl;
import com.plate.dao.impl.BanksDAOImpl;
import com.plate.model.Accounts;
import com.plate.model.AccountsFilter;
import com.plate.model.Banks;
import com.plate.service.AccountsService;


@Named
@ViewScoped
public class AccountsBean implements Serializable {


	private static final long serialVersionUID = 1L;

	
	@Inject
	private AccountsDAOlmpl dao;
	@Inject
	private Accounts account;
	private List<Accounts> accounts;
	private AccountsFilter filter;
	private List<Banks> listBanks;
	private Long id;
	
	
	public AccountsBean() {
		filter = new AccountsFilter();
		account = new Accounts();
	}

	public void load(){
		BanksDAOImpl dao = new BanksDAOImpl();
		listBanks = dao.listAll();
	}
	
	public void getAllClients() {
		accounts = new ArrayList<Accounts>();
		accounts = new AccountsService().listAll();
	}

	public void save() {
		new AccountsService().save(account);
		account = new Accounts();
	}

	public void update() {
		new AccountsService().update(account);
		clean();
	}

	public void delete() {
		new AccountsService().delete(account);
		clean();
	}

	public void search() {
		accounts = new AccountsService().search(filter);
	}

	public void clean() {
		account = new Accounts();
	}

	public AccountsDAOlmpl getDao() {
		return dao;
	}

	public void setDao(AccountsDAOlmpl dao) {
		this.dao = dao;
	}

	public Accounts getAccount() {

		return account;
	}

	public void setAccount(Accounts account) {
		this.account = account;
	}

	public List<Accounts> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Accounts> accounts) {
		this.accounts = accounts;
	}

	public AccountsFilter getFilter() {
		return filter;
	}

	public void setFilter(AccountsFilter filter) {
		this.filter = filter;
	}

	public List<Banks> getListBanks() {
		return listBanks;
	}

	public void setListBanks(List<Banks> listBanks) {
		this.listBanks = listBanks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	
	
	
	
	
	
	
	
	
}
