package com.plate.service;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.plate.dao.impl.CategoriesDAOImpl;
import com.plate.dao.model.CategoriesDAO;
import com.plate.model.Categories;
import com.plate.util.jsf.JSFUtil;

/**
 * @author bruno ferrari
 *
 */

public class CategoriesService implements Serializable {

	private static final long serialVersionUID = 1L;
	private final static Logger logger = Logger.getLogger(CategoriesService.class.toString());
	
	public List<Categories> listAll() {
		CategoriesDAO dao = new CategoriesDAOImpl();
		List<Categories> categories = dao.listAll();
		if (logger.isDebugEnabled()){
			logger.debug("listAllCategories - BEGIN ");
			logger.debug("result: " + categories);
			logger.debug("listAllCategories - END ");
		}
		return categories;
	}
	
	public void delete(Categories category) {
		CategoriesDAO dao = new CategoriesDAOImpl();
		try{
			dao.delete(category);
			JSFUtil.addSuccessMessage("Categoria excluída com sucesso.");
			if (logger.isDebugEnabled())
				logger.debug("deleted: " + category);
			
		} catch (Exception e) {
			JSFUtil.addErrorMessage("Ocorreu um erro ao deletar a categoria. "
					+ "Por favor contate o administrador do sistema.");
			logger.error("EXCEPTION: " + e.getMessage());
		}
	}
	
	public void edit(Categories category) {
		CategoriesDAO dao = new CategoriesDAOImpl();
		
		try{
			dao.saveOrUpdateCategory(category);
			JSFUtil.addSuccessMessage("Categoria alterada com sucesso.");
			if (logger.isDebugEnabled())
				logger.debug("edited: " + category);
		} catch (Exception e) {
			JSFUtil.addErrorMessage("Houve um problema ao tentar alterar a categoria. "
					+ "Por favor contate o administrador do sistema.");
			logger.error("EXCEPTION: " + e.getMessage());
		}
	}
	
	public void save(Categories category) {
		CategoriesDAO dao = new CategoriesDAOImpl();
		try{
			dao.saveOrUpdateCategory(category);
			JSFUtil.addSuccessMessage("Categoria inserida com sucesso.");
			if (logger.isDebugEnabled())
				logger.debug("saved: " + category);
		} catch (Exception e) {
			JSFUtil.addErrorMessage("Houve um problema ao tentar inserir a categoria. "
					+ "Por favor contate o administrador do sistema.");
			logger.error("EXCEPTION: " + e.getMessage());
		}
	}

}
