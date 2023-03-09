package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;
@Autowired
StudentRepository studentRepository;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// create customer
//		Customer customer = new Customer(101,"John doe", "johnd@acme.com", "0622341678");
//		CreditCard creditCard = new CreditCard("12324564321", "Visa", "11/23");
//		customer.setCreditCard(creditCard);
//		customerRepository.save(customer);
//		customer = new Customer(109,"John Jones", "jones@acme.com", "0624321234");
//		creditCard = new CreditCard("657483342", "Visa", "09/23");
//		customer.setCreditCard(creditCard);
//		customerRepository.save(customer);
//		customer = new Customer(66,"James Johnson", "jj123@acme.com", "068633452");
//		creditCard = new CreditCard("99876549876", "MasterCard", "01/24");
//		customer.setCreditCard(creditCard);
//		customerRepository.save(customer);
		//get customers
//		System.out.println(customerRepository.findById(66).get());
//		System.out.println(customerRepository.findById(101).get());
//		System.out.println("-----------All customers ----------------");
//		System.out.println(customerRepository.findAll());
//		//update customer
//		customer = customerRepository.findById(101).get();
//		customer.setEmail("jd@gmail.com");
//		customerRepository.save(customer);
//		System.out.println("-----------find by phone ----------------");
//		System.out.println(customerRepository.findByPhone("0622341678"));
//		System.out.println("-----------find by email ----------------");
//		System.out.println(customerRepository.findCustomerWithEmail("jj123@acme.com"));
//		System.out.println("-----------find customers with a certain type of creditcard ----------------");
//		List<Customer> customers = customerRepository.findCustomerWithCreditCardType("Visa");
//		for (Customer cust : customers){
//			System.out.println(cust);
//		}
		Student student=new Student("Bob Larry","+165862",new Address("4th","Burlinton","52556"));
		Student student1=new Student("Mack Luke","+843465",new Address("5th","Fairfield","52557"));
		Student student2=new Student("Hugo Loris","+874546",new Address("6th","CapeTown","52554"));

		List<Grade> grade=new ArrayList<>();
		Grade gradeWAA=new Grade("WAA","A-");
		Grade gradeEA=new Grade("EA","A+");
		grade.add(gradeWAA);
		grade.add(gradeEA);
		student.setGrade(grade);

		List<Grade> grade1=new ArrayList<>();
		Grade gradeWAA1=new Grade("WAA","A");
		Grade gradeEA1=new Grade("EA","B");
		grade1.add(gradeWAA1);
		grade1.add(gradeEA1);
		student1.setGrade(grade1);

		List<Grade> grade2=new ArrayList<>();
		Grade gradeWAA2=new Grade("WAP","B");
		Grade gradeEA2=new Grade("EA","B+");
		grade2.add(gradeWAA2);
		grade2.add(gradeEA2);
		student2.setGrade(grade2);

		studentRepository.save(student);
		studentRepository.save(student1);
		studentRepository.save(student2);
		System.out.println("-----------find by name ----------------");
		System.out.println(studentRepository.findByName("Bob Larry"));
		System.out.println("-----------find by phone ----------------");
		System.out.println(studentRepository.findByPhone("+874546"));
		System.out.println("-----------find by city ----------------");
		System.out.println(studentRepository.findByCity("Fairfield"));
		System.out.println("-----------find by Course name ----------------");
		System.out.println(studentRepository.findByCourseName("WAP"));
		System.out.println("-----------find A+ by course ----------------");
		System.out.println(studentRepository.findByGrade("EA"));

	}

}
