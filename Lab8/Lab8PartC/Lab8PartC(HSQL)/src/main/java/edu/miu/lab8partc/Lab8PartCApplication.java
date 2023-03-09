package edu.miu.lab8partc;

import edu.miu.lab8partc.domain.Person;
import edu.miu.lab8partc.domain.Pet;
import edu.miu.lab8partc.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class Lab8PartCApplication implements CommandLineRunner {
	@Autowired
	PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(Lab8PartCApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		addPerson();
		retrievePet();

	}

	private void addPerson() {
		StopWatch sw = new StopWatch();
		sw.start();

		for (int x=0; x< 10000; x++){
			int y = 1900 + new Random().nextInt(100-1) + 1;;
			personRepository.save( new Person("Harry","Hudini"+y, addPets()));
		}
		sw.stop();
		long totaltime=sw.getTotalTimeMillis();
		System.out.println("Time taken to add all Person and their Pets in HSQL: "+totaltime+" ms");
	}
	private List<Pet> addPets(){
		List<Pet> pets=new ArrayList<>();
		for(int i=0;i<10;i++){
			pets.add(new Pet("Pet no. "+i+1));
		}
		return pets;
	}
	private void retrievePet() {
		StopWatch sw = new StopWatch();
		sw.start();
		personRepository.findAll();
		sw.stop();
		long totaltime = sw.getTotalTimeMillis();
		System.out.println("Time taken to retrieve all the Person is: " + totaltime + " ms");

	}
}