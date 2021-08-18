package aplazo.com.mx.request;

import java.io.Serializable;
import java.util.List;

public class RequestGeneratePayments implements Serializable {

	private static final long serialVersionUID = 6800042733294548324L;
	
	private Double amount;
	
	private Integer terms;
	
	private Double rate;

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


}
