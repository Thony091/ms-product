package cl.duoc.msproduct.product.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.msproduct.product.model.Product;
import cl.duoc.msproduct.product.service.IProductService;

@RestController
@RequestMapping("/api")
@CrossOrigin(value = "*")
public class ProductRestController {
  @Autowired
  private IProductService productService;
  
  @GetMapping("/products")
  public List<Product> findAllProducts(){
    return productService.findAll();
  }

  @GetMapping("/product/{id}")
  public Optional<Product> findById(@PathVariable Long id){
    Optional<Product> optionalProduct = productService.findById(id);
    if(!optionalProduct.isPresent()) throw new ProductNotFoundException("No existe un producto con el id: "+ id);
    return optionalProduct;
  }

  @PostMapping("/save-product")
  public Product saveProduct(@RequestBody Product product){
    return productService.saveProduct(product);
  }

  @PostMapping("/products/bulk")
  public Set<Product> saveProductInBulk(@RequestBody List<Product> products){
    Set<Product> productSet = new HashSet<>();
    for (Product product : products) {
      try {
        productSet.add(productService.saveProduct(product));
      } catch (Exception e) {
        System.out.println(e.getMessage());
        System.out.println(product.getName());
        System.out.println(product.getUrlImage());
      }
    }

    return productSet;
  }

  @DeleteMapping("/product/{id}")
  public void delete(@PathVariable Long id){
    productService.delete(id);
  }

}

class ProductNotFoundException extends RuntimeException{
  public ProductNotFoundException(String message){
    super(message);
  }

}