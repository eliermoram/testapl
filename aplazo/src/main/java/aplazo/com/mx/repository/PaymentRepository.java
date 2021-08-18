package aplazo.com.mx.repository;

import org.springframework.data.repository.CrudRepository;

import aplazo.com.mx.model.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long>{

}
