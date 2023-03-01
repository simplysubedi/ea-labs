package customers;


public class Product {
    private String name;
    private int id;
    private float price;
     private String description;

    public String getName() {
        return name;
    }

    public Product(String name, int id, float price, String description) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
