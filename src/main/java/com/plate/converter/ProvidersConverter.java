package com.plate.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.plate.dao.impl.ProvidersDAOImpl;
import com.plate.model.Providers;

/**
 * @author bruno ferrari
 *
 */

@FacesConverter(forClass = Providers.class)
public class ProvidersConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		try{
			Long id = Long.parseLong(value);
			ProvidersDAOImpl dao = new ProvidersDAOImpl();
			Providers provider = dao.byId(id);
			return provider;
		} catch (RuntimeException ex) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		try{
			Providers provider = (Providers) value;
			return ((Providers) value).getId().toString();
		} catch (RuntimeException ex) {
			return null;
		}
	}

}
