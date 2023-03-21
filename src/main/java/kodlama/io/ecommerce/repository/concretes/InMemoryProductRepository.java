package kodlama.io.ecommerce.repository.concretes;

import kodlama.io.ecommerce.entities.concretes.Product;
import kodlama.io.ecommerce.repository.abstracts.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class InMemoryProductRepository implements ProductRepository {
    private List<Product>products;
    public InMemoryProductRepository(){
        products=new ArrayList<>();
        products.add(new Product(1,"Iphone 14",10,30000,"apple's product"));
        products.add(new Product(2,"PS5",5,17000,"sony's product"));
        products.add(new Product(3,"Xbox",20,25000,"microsoft's product"));
        products.add(new Product(4,"Ipad Mini",50,12000,"apple's product"));
        products.add(new Product(5,"Dyson v15",10,14999.99,"dyson's product"));
    }
    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product getById(int id) {
        for (Product product : products) {
            if(id==product.getId()){
                return product;
            }
        }
        return null;
    }

    @Override
    public Product add(Product product) {
        products.add(product);
        return product;
    }

    @Override
    public Product update(int id, Product product) {
        return products.set(id-1,product);
    }
    public void delete(int id){
        products.remove(id-1) ;
    }
}
