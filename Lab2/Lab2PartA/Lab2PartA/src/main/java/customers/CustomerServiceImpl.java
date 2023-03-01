package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerDAO customerDAO ;
	@Autowired
	EmailSender emailSender ;
public void setCustomerDAO(CustomerDAOImpl customerDAO){
	this.customerDAO=customerDAO;
}
public void setEmailSender(EmailSenderImpl emailSender){
	this.emailSender=emailSender;
}
	public void addCustomer(String name, String email, String street,
			String city, String zip) {
		Customer customer = new Customer(name, email);
		Address address = new Address(street, city, zip);
		customer.setAddress(address);
		customerDAO.save(customer);
		emailSender.sendEmail(email, "Welcome " + name + " as a new customer");
	}
}
