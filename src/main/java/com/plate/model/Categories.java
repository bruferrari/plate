package com.plate.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author bruno ferrari
 *
 */

@Entity
@Table(name="cf_categories")
@NamedQueries({
	@NamedQuery(name="Categories.list", query="SELECT categories FROM Categories categories"),
	@NamedQuery(name = "Categories.findId", query = "SELECT categories FROM Categories categories WHERE "
			+ "categories.id = :id")
})
public class Categories implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String description;
	private Timestamp date_mod;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="date_mod")
	public Timestamp getDate_mod() {
		return date_mod;
	}

	public void setDate_mod(Timestamp date_mod) {
		this.date_mod = date_mod;
	}

	@Override
	public String toString() {
		return "Categories [id=" + id + ", description=" + description
				+ ", date_mod=" + date_mod + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categories other = (Categories) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
