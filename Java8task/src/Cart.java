import java.util.ArrayList;
import java.util.List;

public class Cart {
    ArrayList<Product> currentProducts;
    public ArrayList<Product> booksList(){
        ArrayList<Product> books=new ArrayList<>();
        for(Product product:this.currentProducts)
        {
            if (product.getCategory().equals("Books"))
                books.add(product);
        }
        return books;
    }
    public ArrayList<Product> expensiveBooksList(){
        ArrayList<Product> expBooks=booksList();
        expBooks.removeIf(product -> product.getPrice() < 100);
        return expBooks;
    }
    public ArrayList<Product> toysList() {
        ArrayList<Product> toys = new ArrayList<>();
        for(Product product:this.currentProducts)
        {
            if (product.getCategory().equals("Toys")){
                product.setPrice(product.getPrice()*0.9); //10% Discount
                toys.add(product);
            }
        }
        return toys;
    }
    public ArrayList<Product> cheapBooksList(){
        ArrayList<Product> cheapBooks=booksList();
        double sum=0.00;
        for(Product product:cheapBooks)
            sum+=product.getPrice();
        final double average=sum/cheapBooks.size();
        cheapBooks.removeIf(product -> product.getPrice() > average);
        return cheapBooks ;
    }
}
