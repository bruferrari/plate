package com.plate.util.jsf;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * @author bruno ferrari
 * @since 07-11-2015
 */
public class JSFUtil implements Serializable{

	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public static void addSuccessMessage(String message) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				message, message);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, msg);
	}
	
	/**
	 * @param message
	 */
	public static void addWarningMessage(String message) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
				message, message);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, msg);
	}
	
	/**
	 * @param message
	 */
	public static void addErrorMessage(String message) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
				message, message);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, msg);
	}
	
}
