package repositories;

import domain.Address;
import domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Integer> {

    @Query(value = "SELECT * FROM Address WHERE city = ?1", nativeQuery = true)
    List<Address> findByCity(String city);

}
