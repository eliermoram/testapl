package aplazo.com.mx.response;

import java.io.Serializable;
import java.util.List;

public class ResponseGeneratePayment implements Serializable {

	private static final long serialVersionUID = 7677261468821706829L;
	
	private List<Payment> payments;

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}
	

}
