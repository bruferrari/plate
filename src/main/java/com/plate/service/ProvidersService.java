package com.plate.service;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.plate.dao.impl.ProvidersDAOImpl;
import com.plate.dao.model.ProvidersDAO;
import com.plate.model.ProviderFilter;
import com.plate.model.Providers;
import com.plate.model.Provinces;
import com.plate.util.jsf.JSFUtil;

/**
 * @author bruno ferrari
 *
 */

public class ProvidersService implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ProvidersService.class.toString());

	public List<Providers> listAll() {
		ProvidersDAO dao = new ProvidersDAOImpl();
		List<Providers> providers = dao.listAll();
		
		if(logger.isDebugEnabled()){
			logger.debug("listProviders - BEGIN");
			logger.debug("result: " + providers);
			logger.debug("listProviders - END");
		}
		
		return providers;
	}
	
//	public List<Provinces> listProvinces() {
//		ProvidersDAOImpl dao = new ProvidersDAOImpl();
//		List<Provinces> provinces = dao.listProvinces();
//		if(logger.isDebugEnabled()){
//			logger.debug("listProvinces - BEGIN");
//			logger.debug("result: " + provinces);
//			logger.debug("listProvinces - END");
//		}
//		return provinces;
//	}
	
	public void delete(Providers provider) {
		ProvidersDAO dao = new ProvidersDAOImpl();
		try {
			dao.delete(provider);
			JSFUtil.addSuccessMessage("Fornecedor deletado com sucesso.");
			if(logger.isDebugEnabled())
				logger.debug("deleted: " + provider);
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.addErrorMessage("Ocorreu um erro ao tentar deletar o fornecedor."
					+ " Por favor contate o administrador do sistema.");
			logger.error("EXCEPTION: " + e.getMessage());
		}
	}
	
	public void save(Providers provider) {
		ProvidersDAO dao = new ProvidersDAOImpl();
		try{
			dao.saveOrUpdate(provider);
			JSFUtil.addSuccessMessage("Fornecedor inserido com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.addErrorMessage("Ocorreu um erro ao tentar inserir o fornecedor."
					+ " Por favor contate o administrador do sistema.");
			logger.error("EXCEPTION: " + e.getMessage());
		}
	}
	
	public void update(Providers provider) {
		ProvidersDAO dao = new ProvidersDAOImpl();
		
		try {
			dao.saveOrUpdate(provider);
			JSFUtil.addSuccessMessage("Fornecedor alterado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.addErrorMessage("Ocorreu um erro ao tentar alterar o fornecedor."
					+ " Por favor contate o administrador do sistema.");
			logger.error("EXCEPTION: " + e.getMessage());
		}
	}
	
	public List<Providers> search(ProviderFilter filter) {
		ProvidersDAO dao = new ProvidersDAOImpl();
		List<Providers> providers = null;
		try {
			providers = dao.search(filter);
			System.out.println("SEARCH RESULT =====> " + providers);
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.addErrorMessage("Ocorreu um erro ao tentar efetuar a pesquisa."
					+ " Por favor contate o administrador do sistema.");
			logger.error("EXCEPTION: " + e.getMessage());
		}
		
		return providers;
	}
	
	public List<Providers> searchByDoc(ProviderFilter filter) {
		ProvidersDAO dao = new ProvidersDAOImpl();
		List<Providers> providers = null;
		try {
			providers = dao.search(filter);
			System.out.println("SEARCH RESULT =====> " + providers);
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtil.addErrorMessage("Ocorreu um erro ao tentar efetuar a pesquisa."
					+ " Por favor contate o administrador do sistema.");
			logger.error("EXCEPTION: " + e.getMessage());
		}
		
		return providers;
	}
}
