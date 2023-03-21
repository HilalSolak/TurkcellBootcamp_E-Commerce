package kodlama.io.ecommerce.api.controllers;

import kodlama.io.ecommerce.business.abstracts.ProductService;
import kodlama.io.ecommerce.entities.concretes.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    private final ProductService service;

    public ProductsController(ProductService service) {
        this.service = service;
    }
    @GetMapping
    public List<Product> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Product getById(int id){
        return service.getById(id);
    }
    @GetMapping("/")
    public Product getTest(@RequestParam int id){
        return service.getById(id);
    }
    @PostMapping
    public Product add(@RequestBody Product product){
        return service.add(product);
    }
    @PutMapping("/{id}")
    public Product update(@PathVariable int id, @RequestBody Product product){
        return service.update(id,product);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }
}

