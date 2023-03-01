package customers;

import org.springframework.stereotype.Component;

@Component
public class ProductDAOImpl implements ProductDAO {

    private Logger logger;

    public ProductDAOImpl(LoggerImpl logger) {this.logger=logger;
    }

    public void save(Product product) {
        // simple sleep
        try {
            Thread.sleep(350);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ProductDAO: saving product "+product.getName());
        logger.log("Product is saved in the DB: "+ product.getName() );
    }
}
