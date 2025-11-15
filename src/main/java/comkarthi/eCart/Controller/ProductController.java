package comkarthi.eCart.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import comkarthi.eCart.Service.ProductService;
import comkarthi.eCart.entity.ProductEntity;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	// Get List of Data
	@GetMapping
	public ResponseEntity<List<ProductEntity>> getAllProductFromService() {
		List<ProductEntity> product = productService.getAllProducts();
		return ResponseEntity.ok(product);
	} 
	
	// API Endpoint for pagination, Eg: GET /api/products/pagination?page=0&size=5
	@GetMapping("/Pagination")
	public Map<String, Object> getAllProductPagination(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
		
		// Calls Service layer method to fetch paginated data
		return productService.getPagination(page, size);
	} 
	
	// View Product API Data by Id
	@GetMapping("/{id}")
	public ProductEntity getProductbyId(@PathVariable Long id) {
		return productService.getProductsById(id);
	
	}
	
	
	
	
}
