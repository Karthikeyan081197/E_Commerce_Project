package comkarthi.eCart.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

	@Entity
	@Table(name = "Products")
	public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    private Long id;

    @Column(nullable = false) // Database: name column cannot be NULL
    @NotBlank(message = "Name field is required") // Validation: cannot be empty or blank
    private String name;

    @Column(nullable = false) // Database: price column cannot be NULL
    @NotNull(message = "Price field is required") // Validation: must have a value
    @PositiveOrZero(message = "Value must be Zero or greater") // Validation: >= 0
    private Double price;

    // Optional field (no validation)
    private String description;
    
    private String category;

    // Optional field with default value
    private Double ratings = 0.0;

    @NotBlank(message = "Seller field is required") // Validation for seller
    private String seller;

    @NotNull(message = "Stock field is required") // Validation for stock
    private Integer stock;

    // Optional field with default value
    private Integer noOfReviews = 0;
    
    // cascade - Changes will be occur in both parent & child table
    // orphanRemoval - Parent data deletion will remove on child table also
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "product_id") // Foreign key in ProductImageEntity Table
    private List<ProductImageEntity> images;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "product_id") // Foreign key in ProductImageEntity Table
    private List<ProductReviewEntity> reviews;
	
	// Used to initialize all fields when creating an object manually
	public ProductEntity(Long id, String name, Double price, String description, String category, Double ratings, String seller,
			Integer stock, Integer noOfReviews) {
		
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.category = category;
		this.ratings = ratings;
		this.seller = seller;
		this.stock = stock;
		this.noOfReviews = noOfReviews;
	}
	
	// Default or No args constructor required by JPA,
	// uses a reflection to create an object 
	public ProductEntity() {
		
	}
	
	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getRatings() {
		return ratings;
	}
	
	public void setRatings(Double ratings) {
		this.ratings = ratings;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getNoOfReviews() {
		return noOfReviews;
	}

	public void setNoOfReviews(Integer noOfReviews) {
		this.noOfReviews = noOfReviews;
	} 
	
	
	
	
	
	
}
