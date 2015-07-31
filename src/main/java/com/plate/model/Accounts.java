package com.plate.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="accounts")
@NamedQueries({
	@NamedQuery (name="Accounts.list", query="SELECT accounts FROM Accounts accounts"),
	@NamedQuery(name = "Accounts.findId", query = "SELECT accounts FROM Accounts accounts WHERE "
			+ "accounts.id = :id")
})
public class Accounts implements Serializable{

	
	private static final long serialVersionUID = 1L;

	private Long id;
	private String description;
	private BigDecimal balance;
	private Date balanceDate;
	private String type;
	private Banks banks;
	private BigDecimal balance_final;
	
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@NotBlank
	@Column(name="description", nullable = false)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@NotNull
	@Column(name = "balance", precision = 11, scale = 2, nullable = false)
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_balance", nullable = false)
	public Date getBalanceDate() {
		return balanceDate;
	}
	public void setBalanceDate(Date balanceDate) {
		this.balanceDate = balanceDate;
	}
	
	
	@NotNull
	@Column(name = "type", nullable = false)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@NotNull(message = "Campo Banco obrigatorio")
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_bank", referencedColumnName = "id", nullable = false)
	public Banks getBanks() {
		return banks;
	}
	public void setBanks(Banks banks) {
		this.banks = banks;
	}
	
	@NotNull
	@Column(name = "balance_final", precision = 11, scale = 2, nullable = false)
	public BigDecimal getBalance_final() {
		return balance_final;
	}
	public void setBalance_final(BigDecimal balance_final) {
		this.balance_final = balance_final;
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
		Accounts other = (Accounts) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Accounts [id=" + id + ", description=" + description
				+ ", balance=" + balance + ", balanceDate=" + balanceDate
				+ ", type=" + type + ", banks=" + banks + "]";
	}


	
}
