package jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class CalculatorMessageListener {
private int result=0;
    @JmsListener(destination = "calcQueue")
    public void receiveMessage(final String calcAsString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Calculator calculator = objectMapper.readValue(calcAsString, Calculator.class);
            System.out.println("JMS receiver received message:" + calculator.getNum()+" "+calculator.getOperator());
            String operator=calculator.getOperator();

            if(operator.equals("+")){
                 result=result+calculator.getNum();
                System.out.println("The result of the + operation is : "+ result);

            }
            else if(operator.equals("-")){
                System.out.println("The result of the - operation is : "+(result-calculator.getNum()));
                result=result*calculator.getNum();
            }
           else if(operator.equals("*")){
                System.out.println("The result of the * operation is : "+(result*calculator.getNum()));
                result=result*calculator.getNum();
            }
            else
                System.out.println("Invalid parameters");

        } catch (IOException e) {
            System.out.println("JMS receiver: Cannot convert : " + calcAsString+" to a Calculator object");
        }
    }
}
