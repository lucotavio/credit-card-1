package br.com.luciano.creditcard.service;

import br.com.luciano.creditcard.domain.Payment;
import br.com.luciano.creditcard.domain.PaymentEvent;
import br.com.luciano.creditcard.domain.PaymentState;
import br.com.luciano.creditcard.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@SpringBootTest
public class PaymentServiceImplTest {

    @Autowired
    PaymentService paymentService;

    @Autowired
    PaymentRepository paymentRepository;

    Payment payment;

    @BeforeEach
    void setUp() {
        payment = Payment.builder().amount(new BigDecimal("12.99")).build();
    }

    @Transactional
    @Test
    void preAuth() {
        Payment savedPayment = paymentService.newPayment(payment);

        StateMachine<PaymentState, PaymentEvent> sm = paymentService.preAuth(savedPayment.getId());

        Payment preAuthedPayment = paymentRepository.findById(savedPayment.getId()).orElse(null);

        System.out.println(sm.getState().getId());
        System.out.println(preAuthedPayment);
    }
}
