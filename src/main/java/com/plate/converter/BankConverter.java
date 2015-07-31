package com.plate.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import com.plate.dao.impl.BanksDAOImpl;
import com.plate.model.Banks;


@FacesConverter("bankConverter")
public class BankConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent componente,
			String valor) {
		try {
			Long codigo = Long.parseLong(valor);
			BanksDAOImpl bDao = new BanksDAOImpl();
			Banks bank = bDao.findId(codigo);
			return bank;
		} catch (RuntimeException e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent componente,
			Object objeto) {
		try {	//Converte o objeto para um objeto do tipo bank
			Banks bank = (Banks) objeto;
			Long codigo = bank.getId();
			return codigo.toString();
		} catch (RuntimeException e) {
		return null;
	}
	}

}
