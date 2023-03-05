package edu.miu.lab6partb;

import edu.miu.lab6partb.domain.Course;
import edu.miu.lab6partb.domain.Department;
import edu.miu.lab6partb.domain.Grade;
import edu.miu.lab6partb.domain.Student;
import edu.miu.lab6partb.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication


public class Lab6PartBApplication implements CommandLineRunner{
    @Autowired
    StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(Lab6PartBApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {



        Department department = new Department("CS");
Department department1=new Department("ART");
        List<Grade> grade = new ArrayList<>();
        grade.add(new Grade("A-",new Course("EA")));
        grade.add(new Grade("B+",new Course("WAA")));
        Student student = new Student("Bob Hoopkins", 565);
        student.setGrade(grade);
        student.setDepartment(department);
        studentRepository.save(student);

        System.out.println(studentRepository.findAllByDepartment("CS"));
        System.out.println(studentRepository.findALlStudentByCourse("EA"));


    }
}
