package cl.duoc.msproduct.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.duoc.msproduct.product.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long>{
  
}