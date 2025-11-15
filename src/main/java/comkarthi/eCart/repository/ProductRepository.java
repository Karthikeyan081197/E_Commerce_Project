package comkarthi.eCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import comkarthi.eCart.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{

}
