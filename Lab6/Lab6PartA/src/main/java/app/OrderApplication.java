package app;

import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.w3c.dom.ls.LSOutput;
import repositories.*;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain") 
public class OrderApplication implements CommandLineRunner{
	@Autowired
AddressRepository addressRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	OrderLineRepository orderLineRepository;

	@Autowired
	ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product product = new Product();
		product.setName("Hibernate 3");
		product.setDescription("Good book on Hibernate");
		product.setPrice(35.50);


		OrderLine ol1 = new OrderLine(2, product);

		Product product2 = new Product();
		product2.setName("The best of Queen");
		product2.setDescription("Album from 1995");
		product2.setPrice(12.98);
		OrderLine ol2 = new OrderLine(4, product2);
		CD cd=new CD("Zone 66","Songs for all Weather",5,"U2");
OrderLine ol3=new OrderLine(2,cd);
		Order o1 = new Order("234743", "12/10/06", "closed");
		o1.addOrderLine(ol1);
		o1.addOrderLine(ol2);
		o1.addOrderLine(ol3);

		Customer c1 = new Customer("Frank", "Brown", "Mainstreet 1",
				"Amsterdam", "43221","USA");
		c1.addOrder(o1);
		o1.setCustomer(c1);

orderRepository.save(o1);

		System.out.println("////////////////////////////////////////////////////");
		printOrder(orderRepository.findById("234743").get());
		System.out.println(customerRepository.findAll());
		System.out.println("//////////////////////finding CDs//////////////////////////////");
		System.out.println(productRepository.findByArtistAndPriceLessThan("U2",10));
		System.out.println("//////////////////////finding Customers form US//////////////////////////////");
		System.out.println(customerRepository.findAllByCountry("USA"));
		System.out.println("//////////////////////finding CD by ArtistName//////////////////////////////");
		System.out.println(productRepository.findBYArtistName("U2"));
		System.out.println("//////////////////////finding Orderrn bt status//////////////////////////////");
		System.out.println(orderRepository.findOrderrnByCurrentStatus("closed"));
		System.out.println("//////////////////////finding from city//////////////////////////////");

		System.out.println(customerRepository.findCustomerByCity("Amsterdam"));
		System.out.println("//////////////////////finding ordernrfrom city//////////////////////////////");

		System.out.println(orderRepository.findOrderrnByCity("Amsterdam"));
		System.out.println("//////////////////////finding cd by artist and price//////////////////////////////");
		System.out.println(productRepository.findCDbyArtistAndPrice("U2",14.5));
		System.out.println("//////////////////////finding addresses in Amsterdam//////////////////////////////");
		System.out.println(addressRepository.findByCity("Amsterdam"));
		System.out.println("//////////////////////finding CDs of Artist//////////////////////////////");
		System.out.println(productRepository.findCDsByArtist("U2"));
	}

	public static void printOrder(Order order) {
		System.out.println("Order with orderNumber: " + order.getOrdernr());
		System.out.println("Order date: " + order.getDate());
		System.out.println("Order status: " + order.getStatus());
		Customer cust = order.getCustomer();
		System.out.println("Customer: " + cust.getFirstname() + " "
				+ cust.getLastname());
		for (OrderLine orderline : order.getOrderlines()) {
			System.out.println("Order line: quantity= "
					+ orderline.getQuantity());
			Product product = orderline.getProduct();
			System.out.println("Product: " + product.getName() + " "
					+ product.getDescription() + " " + product.getPrice());
		}

	}

}
