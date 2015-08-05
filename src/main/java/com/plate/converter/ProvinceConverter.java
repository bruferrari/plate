package com.plate.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.plate.dao.impl.ProvincesDAOImpl;
import com.plate.model.Provinces;

/**
 * @author bruno ferrari
 * Converter for Provinces objects
 */

@FacesConverter(forClass = Provinces.class)
public class ProvinceConverter implements Converter {
	
	private ProvincesDAOImpl dao;
	
	public ProvinceConverter() {
		dao = new ProvincesDAOImpl();
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,String value) {
		Provinces result = null;
		
		try{
			Long id = new Long(value);
			result = dao.byId(id);
			return result;
		} catch (RuntimeException ex) {
			return null;
		}
		
//		if(value != null) {
//			Long id = new Long(value);
//			result = dao.byId(id);
//		}
//		return result;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,Object value) {
		try{
			Provinces province = (Provinces) value;
			return ((Provinces) value).getId().toString();
		} catch (RuntimeException ex) {
			return null;
		}
		
//		if(value != null) {
//			return ((Provinces) value).getId().toString();
//		}
//		return "";
	}

}
