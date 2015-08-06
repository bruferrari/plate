package com.plate.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.plate.dao.impl.CategoriesDAOImpl;
import com.plate.model.Categories;
import com.plate.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Categories.class)
public class CategoriesConverter implements Converter {

	private CategoriesDAOImpl categoriesDAOImpl;
	
	public CategoriesConverter() {
		categoriesDAOImpl = CDIServiceLocator.getBean(CategoriesDAOImpl.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Categories retorno = null;
		
		if (value != null) {
			Long id = new Long(value);
			retorno = categoriesDAOImpl.findId(id);
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Categories produto = (Categories) value;
			return produto.getId() == null ? null : produto.getId().toString();
		}
		
		return "";
	}
 
}