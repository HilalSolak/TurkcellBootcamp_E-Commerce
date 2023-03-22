package kodlama.io.ecommerce.business.concretes;

import kodlama.io.ecommerce.business.abstracts.ProductService;
import kodlama.io.ecommerce.entities.concretes.Product;
import kodlama.io.ecommerce.repository.abstracts.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductManager implements ProductService {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getAll() {
        return repository.getAll();
    }

    @Override
    public Product getById(int id) {
        return repository.getById(id);
    }

    @Override
    public Product add(Product product) {
        validateProduct(product);
        return repository.add(product);
    }

    @Override
    public Product update(int id, Product product) {
        validateProduct(product);
        return repository.update(id, product);
    }


    @Override
    public void delete(int id) {
        repository.delete(id);
    }
    private void  checkIfPriceValid(Product product){
        if(product.getPrice()<=0)throw new IllegalArgumentException("Price cannot be less than or equal to zero");

    }
    private void checkIfQuantityValid(Product product){
        if(product.getQuantity()<0) throw new IllegalArgumentException("Quantity cannot be less than or equal to zero");
    }
    private void checkIfDescriptionLengthValid(Product product) {
        if (product.getDescription().length()<10 || product.getDescription().length()>50) throw new IllegalArgumentException("Description length must be between 10 and 50 characters. ");
    }
    private void validateProduct(Product product){
        checkIfPriceValid(product);
        checkIfQuantityValid(product);
        checkIfDescriptionLengthValid(product);
    }

}
