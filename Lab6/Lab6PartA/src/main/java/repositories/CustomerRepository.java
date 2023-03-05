package repositories;

import domain.Customer;
import domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Override
    List<Customer> findAll();
List<Customer>findAllByCountry(String country);
    @Query("select cust.firstname,cust.lastname from Customer cust where cust.address.city=:city")
    List<String>findCustomerByCity(@Param("city")String  city);


}