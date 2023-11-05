package cl.duoc.msproduct.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.duoc.msproduct.product.model.Product;
import cl.duoc.msproduct.product.repository.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

  @Autowired
  private IProductRepository productRepository;

  public Product saveProduct(Product product){
    return productRepository.save(product);
  }

  @Override
  @Transactional(readOnly = true)
  public List<Product> findAll() {
    return (List<Product>) productRepository.findAll();
  }

  @Override
  public Optional<Product> findById(Long id) {
    return productRepository.findById(id);
  }

 

  @Override
  public void delete(Long id) {
    productRepository.deleteById(id);
  }


}
