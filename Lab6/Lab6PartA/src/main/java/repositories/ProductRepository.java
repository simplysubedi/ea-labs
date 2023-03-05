package repositories;
import domain.Address;
import domain.CD;
import domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<CD> findByArtistAndPriceLessThan(String name,double price);
    List<CD>findBYArtistName(String name);
@Query("select cd from CD cd where cd.artist=:artist and cd.price>:price")
    List<CD>findCDbyArtistAndPrice(String artist,Double price);
    @Query(value = "SELECT * FROM product p,cd join cd on p.product_number=cd.product_number WHERE cd.artist =:artist", nativeQuery = true)
    List<CD> findCDsByArtist(@Param("artist")String artist);

}
