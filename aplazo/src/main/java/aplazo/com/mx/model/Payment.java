package aplazo.com.mx.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="payment_id")
	private long paymentId;
	
	@Column(name = "payment_number")
	private Integer paymentNumber;
	
	@Column
	private Double amount;
	
	@Column(name = "payment_date")
	private Date paymentDate;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="credit_id", nullable = false)
	private Credit credit;

	public Payment(Integer paymentNumber, Double amount, Date paymentDate, Credit credit) {
		super();
		this.paymentNumber = paymentNumber;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.credit = credit;
	}
	
	public Payment() {
		super();
	}

	public long getIPaymentd() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	public Integer getPaymentNumber() {
		return paymentNumber;
	}

	public void setPaymentNumber(Integer paymentNumber) {
		this.paymentNumber = paymentNumber;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Credit getCredit() {
		return credit;
	}

	public void setCredit(Credit credit) {
		this.credit = credit;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentNumber=" + paymentNumber + ", amount=" + amount
				+ ", paymentDate=" + paymentDate 
				//+ ", credit=" + credit 
				+ "]";
	}

}
