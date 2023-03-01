package customers;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Profile("Test")
@Repository
public class CustomerDAOMockImpl implements CustomerDAO {
    private LoggerImpl logger;
    public CustomerDAOMockImpl(LoggerImpl logger) {this.logger=logger;
    }

    @Override
    public void save(Customer customer) {
        try {
            Thread.sleep(350);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("CustomerDAOMock: saving customer "+customer.getName());
        logger.log("Customer is saved in the DB in Test: "+ customer.getName() );
    }
    }

