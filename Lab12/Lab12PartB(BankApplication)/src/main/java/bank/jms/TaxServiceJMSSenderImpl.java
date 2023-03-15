package bank.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@EnableJms
public class TaxServiceJMSSenderImpl implements TaxServiceJMSSender {
    @Autowired
    JmsTemplate jmsTemplate;
    @Override
    public void sendDepositJMSMessage(String text) {
        jmsTemplate.convertAndSend("bankQueue",text);
    }


}
