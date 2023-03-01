package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService{
    @Autowired
    IProductDAO productDAO ;
    @Autowired
    IEmailSender emailSender ;
    public void setCustomerDAO(CustomerDAO customerDAO){
        this.productDAO=productDAO;
    }
    public void setEmailSender(EmailSender emailSender){
        this.emailSender=emailSender;
    }

    @Override
    public void addProduct(String name, int id, float price, String description) {
        Product product=new Product(name,id,price,description);
        productDAO.save(product);
        emailSender.sendEmail("arjun.subedi@gmail.com", "Product: " + name + " saved");
    }
}
