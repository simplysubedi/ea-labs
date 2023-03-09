package edu.miu.lab8partc.repositories;

import edu.miu.lab8partc.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Integer> {
}
