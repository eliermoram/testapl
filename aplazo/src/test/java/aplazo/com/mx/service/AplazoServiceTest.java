package aplazo.com.mx.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import aplazo.com.mx.repository.CreditRepository;
import aplazo.com.mx.repository.PaymentRepository;
import aplazo.com.mx.request.RequestGeneratePayments;

@SpringBootTest
public class AplazoServiceTest {

	@Autowired
	AplazoService aplazoService;
	
	@Autowired
	PaymentRepository paymentRepository;
	
	@Autowired
	CreditRepository creditRepository;
	
	@BeforeEach
	public void beforeTest() {
		paymentRepository.deleteAll();
		creditRepository.deleteAll();
	}
	
	@Test
	void testGetCredits() {
		
		RequestGeneratePayments request = new RequestGeneratePayments();
		request.setAmount(100.0);
		request.setTerms(5);
		request.setRate(10.0);
		aplazoService.calculatePayments(request);
		
		assertEquals(1, aplazoService.getCredits().size());
	}
	
	@Test
	void testCalculatePayments() {
		
		RequestGeneratePayments request = new RequestGeneratePayments();
		request.setAmount(100.0);
		request.setTerms(5);
		request.setRate(10.0);

		assertEquals(5, aplazoService.calculatePayments(request).size());
	}
}
