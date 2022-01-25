package br.com.luciano.creditcard.listener;

import br.com.luciano.creditcard.domain.PaymentEvent;
import br.com.luciano.creditcard.domain.PaymentState;
import lombok.extern.java.Log;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

@Log
public class StateMachineListenerAdapterLog extends StateMachineListenerAdapter<PaymentState, PaymentEvent> {

    @Override
    public void stateChanged(State<PaymentState, PaymentEvent> from, State<PaymentState, PaymentEvent> to) {
        log.info(String.format("State changed(from %s to %s)", from, to) );
    }
}

