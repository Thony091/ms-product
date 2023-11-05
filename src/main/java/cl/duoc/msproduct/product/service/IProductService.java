package cl.duoc.msproduct.product.service;

import java.util.List;
import java.util.Optional;

import cl.duoc.msproduct.product.model.Product;

public interface IProductService {
  public List<Product> findAll();  
  public Optional<Product> findById(Long id);  
  public Product saveProduct(Product product);  
  public void delete(Long id);  
}