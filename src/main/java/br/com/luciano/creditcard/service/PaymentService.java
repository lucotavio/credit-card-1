package br.com.luciano.creditcard.service;

import br.com.luciano.creditcard.domain.Payment;
import br.com.luciano.creditcard.domain.PaymentEvent;
import br.com.luciano.creditcard.domain.PaymentState;
import org.springframework.statemachine.StateMachine;

public interface PaymentService {

    Payment newPayment(Payment payment);

    StateMachine<PaymentState, PaymentEvent> preAuth(Long paymentId);

    StateMachine<PaymentState, PaymentEvent> authorizePayment(Long paymentId);

    StateMachine<PaymentState, PaymentEvent> declineAuth(Long paymentId);
}
