package com.plate.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.plate.dao.impl.ProvidersDAOImpl;
import com.plate.model.Cities;
import com.plate.model.ProviderFilter;
import com.plate.model.Providers;
import com.plate.model.Provinces;
import com.plate.service.CitiesService;
import com.plate.service.ProvidersService;
import com.plate.service.ProvincesService;

/**
 * @author bruno ferrari
 *
 */

@Named
@ViewScoped
public class ProvidersBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProvidersDAOImpl dao;

	@Inject
	private Providers provider;

	@Inject
	private Cities city;

	private Long selectedProvince;
	private Long selectedCity;

	private List<Providers> providers;
	private List<Provinces> provinces;
	private List<Cities> cities;
	private ProviderFilter filter;

	private String radioResult = "razao";

	public ProvidersBean() {
		filter = new ProviderFilter();
	}

	public void getAllProviders() {
		providers = new ArrayList<Providers>();
		providers = new ProvidersService().listAll();
	}

	public void saveOrUpdate() {
		if (isEditing()) {
			new ProvidersService().update(provider);
		} else {
			new ProvidersService().save(provider);
			clean();
		}
	}

	public void delete() {
		new ProvidersService().delete(provider);
		clean();
	}

	public void search() {
		if (radioResult.equals("razao"))
			providers = new ProvidersService().search(filter);
		else
			providers = new ProvidersService().searchByDoc(filter);
	}

	public void clean() {
		provider = new Providers();
	}

	public boolean isEditing() {
		return this.provider.getId() != null;
	}

	public void listAllCities() {
		cities = new CitiesService().listAll(selectedProvince);
	}

	public void listAllProvinces() {
		provinces = new ProvincesService().listAll();
	}

	/**
	 * @return
	 */
	public Providers getProvider() {
		return provider;
	}

	/**
	 * @param provider
	 */
	public void setProvider(Providers provider) {
		this.provider = provider;
	}

	/**
	 * @return
	 */
	public List<Providers> getProviders() {
		return providers;
	}

	/**
	 * @param providers
	 */
	public void setProviders(List<Providers> providers) {
		this.providers = providers;
	}

	/**
	 * @return
	 */
	public ProviderFilter getFilter() {
		return filter;
	}

	/**
	 * @param filter
	 */
	public void setFilter(ProviderFilter filter) {
		this.filter = filter;
	}

	/**
	 * @return
	 */
	public List<Provinces> getProvinces() {
		return provinces;
	}

	/**
	 * @param provinces
	 */
	public void setProvinces(List<Provinces> provinces) {
		this.provinces = provinces;
	}

	/**
	 * @return
	 */
	public String getRadioResult() {
		return radioResult;
	}

	/**
	 * @param radioResult
	 */
	public void setRadioResult(String radioResult) {
		this.radioResult = radioResult;
	}

	/**
	 * @return
	 */
	public List<Cities> getCities() {
		return cities;
	}

	/**
	 * @param cities
	 */
	public void setCities(List<Cities> cities) {
		this.cities = cities;
	}

	/**
	 * @return
	 */
	public Cities getCity() {
		return city;
	}

	/**
	 * @param city
	 */
	public void setCity(Cities city) {
		this.city = city;
	}

	/**
	 * @return
	 */
	public Long getSelectedProvince() {
		return selectedProvince;
	}

	/**
	 * @param selectedProvince
	 */
	public void setSelectedProvince(Long selectedProvince) {
		this.selectedProvince = selectedProvince;
	}

	/**
	 * @return
	 */
	public Long getSelectedCity() {
		return selectedCity;
	}

	/**
	 * @param selectedCity
	 */
	public void setSelectedCity(Long selectedCity) {
		this.selectedCity = selectedCity;
	}

}
