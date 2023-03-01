package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDAO productDAO ;
    @Autowired
    EmailSender emailSender ;
    public void setCustomerDAO(CustomerDAOImpl customerDAO){
        this.productDAO=productDAO;
    }
    public void setEmailSender(EmailSenderImpl emailSender){
        this.emailSender=emailSender;
    }

    @Override
    public void addProduct(String name, int id, float price, String description) {
        Product product=new Product(name,id,price,description);
        productDAO.save(product);
        emailSender.sendEmail("arjun.subedi@gmail.com", "Product: " + name + " saved");
    }
}
