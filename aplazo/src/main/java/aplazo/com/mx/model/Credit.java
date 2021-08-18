package aplazo.com.mx.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table
public class Credit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="credit_id")
	private long creditId;
	
	@Column
	private Double amount;
	
	@Column
	private Integer terms;
	
	@Column
	private Double rate;

	@JsonManagedReference
	@OneToMany(mappedBy = "credit", cascade = CascadeType.ALL)
	private Set<Payment> payments;
	
	public Credit(Double amount, Integer terms, Double rate) {
		super();
		this.amount = amount;
		this.terms = terms;
		this.rate = rate;
	}
	
	public Credit() {
		super();
	}

	public long getCreditId() {
		return creditId;
	}

	public void setCreditId(long creditId) {
		this.creditId = creditId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getTerms() {
		return terms;
	}

	public void setTerms(Integer terms) {
		this.terms = terms;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Set<Payment> getPayments() {
		return payments;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}

	@Override
	public String toString() {
		return "Credit [creditId=" + creditId + ", amount=" + amount + ", terms=" + terms + ", rate=" + rate
				//+ ", payments=" + payments 
				+ "]";
	}
	
	
}
