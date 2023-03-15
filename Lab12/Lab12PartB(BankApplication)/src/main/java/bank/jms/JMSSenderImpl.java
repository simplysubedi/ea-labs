package bank.jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@EnableJms
public class JMSSenderImpl implements JMSSender {
	@Autowired
	JmsTemplate jmsTemplate;

	public void sendJMSMessage (String text){
		System.out.println("JMSSender: sending jms message= "+text);

	}


}
