package aplazo.com.mx.response;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

public class Payment implements Serializable{
	
	private static final long serialVersionUID = -2078641673671334727L;

	@JsonProperty(value = "payment_number")
	private Integer paymentNumber;
	
	private Double amount;
	
	@JsonProperty(value = "payment_date")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "YYYY-MM-DD")
	private Date paymentDate;

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
	

}
