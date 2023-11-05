package cl.duoc.msproduct.product.controller;

import java.util.List;
import java.util.Optional;

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
public class ProductRestController {

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