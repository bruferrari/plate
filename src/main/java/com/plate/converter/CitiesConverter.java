package com.plate.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.plate.dao.impl.CitiesDAOImpl;
import com.plate.model.Cities;
import com.plate.model.Provinces;
import com.plate.util.cdi.CDIServiceLocator;

/**
 * @author bruno ferrari
 * Converter for Cities objects
 */

@FacesConverter(forClass = Cities.class)
public class CitiesConverter implements Converter {
	
	private CitiesDAOImpl dao;
	
	public CitiesConverter() {
		dao = CDIServiceLocator.getBean(CitiesDAOImpl.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,String value) {
		Cities result = null;
		
		if(value != null) {
			Long id = new Long(value);
			result = dao.byId(id);
		}
		return result;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,Object value) {
	
		if (value != null) {
			Cities city = (Cities) value;
			return city.getId() == null ? null : city.getId().toString();
		}
		return "";
	}
}
