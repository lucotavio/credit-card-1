package br.com.luciano.creditcard.repository;

import br.com.luciano.creditcard.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
