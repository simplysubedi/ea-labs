package repositories;

import domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,String > {
    @Query("select ord.ordernr from Order ord where ord.status=:status")
    List<String> findOrderrnByCurrentStatus(@Param("status")String status);
    @Query("select ordnum.ordernr from Order ordnum where ordnum.customer.address.city=:city")
    List<String>findOrderrnByCity(@Param("city")String city);
}
