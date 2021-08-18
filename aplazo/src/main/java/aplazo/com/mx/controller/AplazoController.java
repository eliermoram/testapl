package aplazo.com.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import aplazo.com.mx.model.Credit;
import aplazo.com.mx.request.RequestGeneratePayments;
import aplazo.com.mx.response.Payment;
import aplazo.com.mx.response.ResponseGeneratePayment;
import aplazo.com.mx.service.AplazoService;

@RestController
public class AplazoController {
	
	@Autowired
	AplazoService aplazoService;
	
	@GetMapping("/health")
    public String healthCheck() {
        return "it is alive";
    }
	
	@PostMapping("/generatePayment")
	public @ResponseBody ResponseGeneratePayment generatePayment(@RequestBody RequestGeneratePayments request) {
		
		ResponseGeneratePayment response = new ResponseGeneratePayment();
		
		List<Payment> payments = aplazoService.calculatePayments(request);
		
		response.setPayments(payments);
		
		return response;
	}
	
	@GetMapping("/credits")
	public @ResponseBody List<Credit> getCredits(){
		
		return aplazoService.getCredits();
	}

}
