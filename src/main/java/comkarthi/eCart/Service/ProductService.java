package comkarthi.eCart.Service;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import comkarthi.eCart.entity.ProductEntity;
import comkarthi.eCart.repository.ProductRepository;

// Service Layer: Contains business logic.
// Communicates with the Repository to perform CRUD operations,
// and returns the processed result back to the Controller.
@Service 
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    } 

	
	// Method to get paginated list of products
    public Map<String, Object> getPagination(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
         
        // Returns a Page<ProductEntity> object (not List)
        Page<ProductEntity> products = productRepository.findAll(pageable);

        // Create a Map to store both data + total count
        Map<String, Object> response = new HashMap<>();

        // products.getContent() → gives actual product list of that page
        response.put("products", products.getContent());

        // products.getTotalElements() → total number of products in DB
        response.put("totalProducts", products.getTotalElements());

        // Returning both as a single response
        return response;
    }
    
    // View Product API
    public ProductEntity getProductsById(Long id) {
    		return productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND ,"Product not Found: " + id));
	}

}
