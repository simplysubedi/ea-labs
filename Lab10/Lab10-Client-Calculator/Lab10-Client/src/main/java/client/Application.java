package client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	CalculatorClient calculatorClient;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Adding 7 and 9= "+calculatorClient.add(7,9));
		System.out.println("Multiplying 11 and 48= "+calculatorClient.multiply(11,48));
		System.out.println("Subtracting 56 from 89= "+calculatorClient.subtract(89,56));
	}

}


