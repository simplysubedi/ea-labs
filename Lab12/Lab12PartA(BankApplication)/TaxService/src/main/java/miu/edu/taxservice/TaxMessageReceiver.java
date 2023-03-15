package miu.edu.taxservice;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TaxMessageReceiver {
    @JmsListener(destination = "bankQueue")
    public void receiveMessage(final String text) {
        try {
            System.out.println("Message received: "+text);

        } catch (Exception e) {
            System.out.println("Error receiving message");
        }

    }

}