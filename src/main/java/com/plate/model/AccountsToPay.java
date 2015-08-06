package com.plate.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="accounts_pay")
@NamedQueries({
	@NamedQuery (name="AccountsToPay.list", query="SELECT accounts_pay FROM AccountsToPay accounts_pay"),
	@NamedQuery(name = "AccountsToPay.findId", query = "SELECT accounts_pay FROM AccountsToPay accounts_pay WHERE "
			+ "accounts_pay.id = :id")
})
public class AccountsToPay implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	@Size(max = 80)
	@Column(name = "description", nullable = false, length = 80)
	private String description;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "accounts_id",  nullable = false)
	private Accounts accounts;
	
	@NotBlank
	@Size(max = 80)
	@Column(name = "provider", nullable = false, length = 80)
	private String provider;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "categories",  nullable = false)
	private Categories categories;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateExpiration", nullable = true)
	private Date dateExpiration;
	
	@NotNull
	@Column(name = "value", nullable = false, precision = 10, scale = 2)
	private BigDecimal value = BigDecimal.ZERO;
	

	
	@Size(max = 80)
	@Column(name = "occurrences", nullable = true, length = 80)
	private String occurrences;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "paymentDate", nullable = true)
	private Date paymentDate;
	
	@Column(name = "discount", nullable = true, precision = 10, scale = 2)
	private BigDecimal discount = BigDecimal.ZERO;
	
	@Column(name = "interest", nullable = true, precision = 10, scale = 2)
	private BigDecimal interest = BigDecimal.ZERO;// Juros
	
	@Column(name = "amountPaid", nullable = true, precision = 10, scale = 2)
	private BigDecimal amountPaid = BigDecimal.ZERO;// Valor Pago

	@NotNull
	@Column(name = "rep", nullable = true)
	private Integer rep;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Accounts getAccounts() {
		return accounts;
	}

	public void setAccounts(Accounts accounts) {
		this.accounts = accounts;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	public Date getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getOccurrences() {
		return occurrences;
	}

	public void setOccurrences(String occurrences) {
		this.occurrences = occurrences;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getInterest() {
		return interest;
	}

	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}

	public BigDecimal getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(BigDecimal amountPaid) {
		this.amountPaid = amountPaid;
	}

	public Integer getRep() {
		return rep;
	}

	public void setRep(Integer rep) {
		this.rep = rep;
	}

	@Override
	public String toString() {
		return "AccountsToPay [id=" + id + ", description=" + description
				+ ", accounts=" + accounts + ", provider=" + provider
				+ ", categories=" + categories + ", dateExpiration="
				+ dateExpiration + ", value=" + value + ", occurrences="
				+ occurrences + ", paymentDate=" + paymentDate + ", discount="
				+ discount + ", interest=" + interest + ", amountPaid="
				+ amountPaid + ", rep=" + rep + "]";
	}
	
	
	
}
