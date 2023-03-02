package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDAO {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void clearDB() {
        Map<String, Object> namedParameters = new HashMap<String, Object>();
        jdbcTemplate.update("DELETE from product", namedParameters);
        jdbcTemplate.update("DELETE from supplier", namedParameters);

    }

    public void save(Product product) {
        Map<String, Object> namedParameters = new HashMap<String, Object>();
        namedParameters.put("productnumber", product.getProductNumber());
        namedParameters.put("name", product.getName());
        namedParameters.put("price", product.getPrice());
        jdbcTemplate.update("INSERT INTO product VALUES ( :productnumber, :name, :price)", namedParameters);

        Map<String, Object> namedParameterS = new HashMap<String, Object>();
        namedParameterS.put("productNumber", product.getProductNumber());
        namedParameterS.put("name", product.getSupplier().getName());
        namedParameterS.put("phone", product.getSupplier().getPhone());
        jdbcTemplate.update("INSERT INTO supplier VALUES ( :name, :phone, :productNumber)", namedParameterS);

    }

    public Product findByProductNumber(int productNumber) {
        Map<String, Object> namedParameters = new HashMap<String, Object>();
        namedParameters.put("productNumber", productNumber);
        Product product = jdbcTemplate.queryForObject("SELECT * FROM product WHERE "
                        + "productNumber =:productNumber ",
                namedParameters,
                (rs, rowNum) -> new Product(rs.getInt("productNumber"),
                        rs.getString("name"),
                        rs.getDouble("price")
                ));
        Supplier supplier = getSupplierforProduct(product.getProductNumber());
        product.setSupplier(supplier);
        return product;
    }

    Supplier getSupplierforProduct(int productNumber) {
        Map<String, Object> namedParameters = new HashMap<String, Object>();
        namedParameters.put("productNumber", productNumber);
        Supplier supplier = jdbcTemplate.queryForObject("SELECT * FROM supplier WHERE "
                        + "productNumber =:productNumber ",
                namedParameters,
                (rs, rowNum) -> new Supplier(rs.getString("name"),
                        rs.getString("phone")));

        return supplier;
    }

    public List<Product> getAllProduct() {
        List<Product> products = jdbcTemplate.query("SELECT * FROM product",
                new HashMap<String, Product>(),
                (rs, rowNum) -> new Product(rs.getInt("productNumber"),
                        rs.getString("name"),
                        rs.getDouble("price")));
        for (Product product : products) {
            Supplier supplier = getSupplierforProduct(product.getProductNumber());
            product.setSupplier(supplier);

        } return products;}
        public Product findByProductName (String name){
            Map<String, Object> namedParameters = new HashMap<>();
            namedParameters.put("name", name);
            Product product = jdbcTemplate.queryForObject("SELECT * FROM product WHERE "
                            + "name =:name ",
                    namedParameters,
                    (rs, rowNum) -> new Product(rs.getInt("productNumber"),
                            rs.getString("name"),
                            rs.getDouble("price")
                    ));
            Supplier supplier = getSupplierforProduct(product.getProductNumber());
            product.setSupplier(supplier);
            return product;
        }
        public void removeProduct ( int productNumber){
            Map<String, Object> namedParameters = new HashMap<>();
            namedParameters.put("productNumber", productNumber);
            jdbcTemplate.update("DELETE FROM product WHERE " + "productNumber =:productNumber", namedParameters);
            System.out.println("The product with number " + productNumber + " has been deleted");

        }

    }


