package aplazo.com.mx.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aplazo.com.mx.model.Credit;
import aplazo.com.mx.repository.CreditRepository;
import aplazo.com.mx.repository.PaymentRepository;
import aplazo.com.mx.request.RequestGeneratePayments;
import aplazo.com.mx.response.Payment;

@Service
public class AplazoService {
	
	@Autowired
	CreditRepository creditRepository;
	
	@Autowired
	PaymentRepository paymentRepository;
	
	private static final Logger log = LoggerFactory.getLogger(AplazoService.class);
	
	public List<Payment> calculatePayments(RequestGeneratePayments request){
		
		List<Payment> payments = new ArrayList<Payment>();
		List<aplazo.com.mx.model.Payment> paymentsEntity = new ArrayList<aplazo.com.mx.model.Payment>();
		
		Double rate = (request.getAmount() * (request.getRate()/100));
		Double amountWithrate = request.getAmount() + rate;
		Double amountWeek = amountWithrate / request.getTerms();
		
		log.info("amount with rate: "+amountWithrate);
		log.info("amount week: "+amountWeek);
		
		Calendar startDate = Calendar.getInstance();
		startDate.add(Calendar.DATE, 7);
		startDate.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		
		Credit credit = new Credit(
				request.getAmount(),
				request.getTerms(),
				request.getRate());
		credit = creditRepository.save(credit);
		
		for(int i=0; i<request.getTerms(); i++) {
			Payment payment = new Payment();
			payment.setAmount(amountWeek);
			payment.setPaymentNumber(i+1);
			payment.setPaymentDate(startDate.getTime());
			
			log.info("start date: "+startDate.getTime());
			startDate.add(Calendar.DATE, 7);
			
			payments.add(payment);
			
			aplazo.com.mx.model.Payment paymentEntity = new aplazo.com.mx.model.Payment(
										payment.getPaymentNumber(),
										payment.getAmount(),
										payment.getPaymentDate(),
										credit);
			
			paymentsEntity.add(paymentEntity);
		}
		paymentRepository.saveAll(paymentsEntity);
		
		return payments;
	}

	public List<Credit> getCredits() {
		
		List<Credit> credits = new ArrayList<Credit>();  
		creditRepository.findAll().forEach(credit -> credits.add(credit));  
		
		return credits; 
	}

}
