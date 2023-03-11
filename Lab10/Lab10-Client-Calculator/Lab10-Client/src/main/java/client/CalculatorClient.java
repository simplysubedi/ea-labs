package client;

import generated.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;


public class CalculatorClient extends WebServiceGatewaySupport {

    public int add(int x, int y) {
        AddRequest request = new AddRequest();
        request.setNumber1(x);
        request.setNumber2(y);

       AddResponse response = (AddResponse)
                getWebServiceTemplate().marshalSendAndReceive(request);
        return response.getResult();
    }
    public int subtract(int x, int y) {
        SubtractRequest request = new SubtractRequest();
        request.setNumber1(x);
        request.setNumber2(y);

       SubtractResponse response = (SubtractResponse)
                getWebServiceTemplate().marshalSendAndReceive(request);
        return response.getResult();
    }
    public int multiply(int x, int y) {
        MultiplyRequest request = new MultiplyRequest();
        request.setNumber1(x);
        request.setNumber2(y);

   MultiplyResponse response = (MultiplyResponse)
                getWebServiceTemplate().marshalSendAndReceive(request);
        return response.getResult();
    }



}
