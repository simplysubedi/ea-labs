package customers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    public CustomerService customerService(){
        CustomerService customerService=new CustomerService();
        customerService.setCustomerDAO(customerDAO());
        customerService.setEmailSender(emailSender());
        return customerService;
    }
    @Bean
    public CustomerDAO customerDAO(){
        return new CustomerDAO(logger());
    }
    @Bean
    public Logger logger(){
        return new Logger();
    }
@Bean public EmailSender emailSender(){
        return new EmailSender(logger());
}
}


