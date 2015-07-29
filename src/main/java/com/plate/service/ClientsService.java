package com.plate.service;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.plate.dao.impl.ClientsDAOImpl;
import com.plate.dao.model.ClientsDAO;
import com.plate.model.Clients;
import com.plate.model.ClientsFilter;
import com.plate.util.jsf.JSFUtil;

/**
 * @author bruno ferrari
 *
 */
public class ClientsService implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ClientsService.class.toString());
	
	public List<Clients> listAll() {
		ClientsDAO dao = new ClientsDAOImpl();
		List<Clients> clients = dao.listAll();
		
		if(logger.isDebugEnabled()){
			logger.debug("listClients - BEGIN");
			logger.debug("result: " + clients);
			logger.debug("listClients - END");
		}
		
		return clients;
	}
	
	public void delete(Clients client) {
		ClientsDAO dao = new ClientsDAOImpl();
		try{
			dao.delete(client);
			JSFUtil.addSuccessMessage("Cliente deletado com sucesso.");
			if(logger.isDebugEnabled())
				logger.debug("deleted: " + client);
		} catch (Exception e) {
			JSFUtil.addErrorMessage("Ocorreu um erro ao tentar deletar o cliente."
					+ " Por favor contate o administrador do sistema.");
			logger.error("EXCEPTION: " + e.getMessage());
		}
	}
	
	public void save(Clients client) {
		ClientsDAO dao = new ClientsDAOImpl();
		
		try{
			dao.saveOrUpdate(client);
			JSFUtil.addSuccessMessage("Cliente inserido com sucesso!");
		} catch (Exception e) {
			JSFUtil.addErrorMessage("Ocorreu um erro ao tentar inserir o cliente."
					+ " Por favor contate o administrador do sistema.");
			logger.error("EXCEPTION: " + e.getMessage());
		}
	}
	
	public void update(Clients client) {
		ClientsDAO dao = new ClientsDAOImpl();
		
		try{
			dao.saveOrUpdate(client);
			JSFUtil.addSuccessMessage("Cliente alterado com sucesso!");
		} catch (Exception e) {
			JSFUtil.addErrorMessage("Ocorreu um erro ao tentar alterar o cliente."
					+ " Por favor contate o administrador do sistema.");
			logger.error("EXCEPTION: " + e.getMessage());
		}
	}
	
	public List<Clients> search(ClientsFilter filter) {
		ClientsDAO dao = new ClientsDAOImpl();
		List<Clients> clients = null;
		
		try{
			clients = dao.search(filter);
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.addErrorMessage("Ocorreu um erro ao tentar efetuar a pesquisa."
					+ " Por favor contate o administrador do sistema.");
			logger.error("EXCEPTION: " + e.getMessage());
		}
		return clients;
	}

}
