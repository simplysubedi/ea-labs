package app;

import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repository.BookRepository;
import repository.DepartmentRepository;
import repository.PassengerRepository;
import repository.SchoolRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@EntityScan("domain")
@EnableJpaRepositories("repository")
public class MainApplication implements CommandLineRunner{
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	BookRepository bookRepository;
	@Autowired
	PassengerRepository passengerRepository;

	@Autowired
	SchoolRepository schoolRepository;
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("..................PartA.................");
		Department department=new Department("Computer Science");
		List<Employee> employee=new ArrayList<Employee>();
		employee.add(new Employee("Harry luke",department));
		employee.add(new Employee("Frank Hat",department));
		department.setEmployee(employee);
		departmentRepository.save(department);
		System.out.println("..................Retreiving the data(Department,Employee).................");
		List<Department> departments=departmentRepository.findAll();
		for (Department depart:departments){
		System.out.println(depart.toString());}

		System.out.println("..................PartB.................");
		Book book =new Book("The art of Lazy Programming","Harry Wolk");

		Publisher publisher=new Publisher("Barry Publication");
		book.setPublisher(publisher);
		bookRepository.save(book);
		System.out.println("..................Retreiving the data(Book, Publisher).................");
		System.out.println(bookRepository.findAll());

		System.out.println("..................PartC.................");
		Passenger passenger=new Passenger("Dowrt Pack");
		List<Flight>flights =new ArrayList<Flight>();
		flights.add(new Flight("BGT568","NY","LA", LocalDate.of(2023,5,16)));
		flights.add(new Flight("VFT468","WDC","IW", LocalDate.of(2023,2,8)));
		passenger.setFlights(flights);
		passengerRepository.save(passenger);
		System.out.println("..................Retreiving the data(Flight,Passengers).................");
		System.out.println(passengerRepository.findAll());

		System.out.println("..................PartD.................");
		School school=new School("St. Luis High School");
		Student student=new Student("Barry","Hoopkins");
		Map<Integer,Student> students=new HashMap<Integer,Student>();
		students.put(1,student);
		school.setStudents (students);
		schoolRepository.save(school);
		System.out.println("..................Retreiving the data(School, Students).................");
		System.out.println(schoolRepository.findAll());

	}
}

