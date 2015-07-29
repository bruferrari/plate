package com.plate.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.plate.dao.impl.ClientsDAOImpl;
import com.plate.model.Clients;
import com.plate.model.ClientsFilter;
import com.plate.service.ClientsService;

/**
 * @author bruno ferrari
 *
 */

@Named
@ViewScoped
public class ClientsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ClientsDAOImpl dao;
	@Inject
	private Clients client;

	private List<Clients> clients;
	private ClientsFilter filter;

	@PostConstruct
	public void init() {
		System.out.println("initializing clients bean...");
	}
	
	public ClientsBean() {
		filter = new ClientsFilter();
	}

	public void getAllClients() {
		clients = new ArrayList<Clients>();
		clients = new ClientsService().listAll();
	}

	public void save() {
		new ClientsService().save(client);
		clean();
	}

	public void update() {
		new ClientsService().update(client);
	}

	public void delete() {
		new ClientsService().delete(client);
		clean();
	}

	public void search() {
		clients = new ClientsService().search(filter);
	}

	public void clean() {
		client = new Clients();
	}

	/**
	 * @return
	 */
	public Clients getClient() {
		return client;
	}

	/**
	 * @param client
	 */
	public void setClient(Clients client) {
		this.client = client;
	}

	/**
	 * @return
	 */
	public List<Clients> getClients() {
		return clients;
	}

	/**
	 * @param clients
	 */
	public void setClients(List<Clients> clients) {
		this.clients = clients;
	}

	/**
	 * @return
	 */
	public ClientsFilter getFilter() {
		return filter;
	}

	/**
	 * @param filter
	 */
	public void setFilter(ClientsFilter filter) {
		this.filter = filter;
	}

}
