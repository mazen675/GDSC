import java.util.Locale;

public class Product {
    private int productID;
    private String ProductName;
    private String category;
    private double price;
    public Product(){
    }
    public Product(int productID,String productName,String category,double price){
        this.productID=productID;
        this.ProductName=productName;
        this.category=category;
        this.price=price;
    }
    public Product withPrice(double price){
        if(this.price==price)
            return this;
        else
            return new Product(this.productID,this.ProductName,this.category,price);
    }
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return
                "{ productID=" + productID +
                ", ProductName='" + ProductName + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
