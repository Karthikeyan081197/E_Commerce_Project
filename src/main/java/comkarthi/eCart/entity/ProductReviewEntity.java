package comkarthi.eCart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "product_review")
public class ProductReviewEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Min(value = 1)
	@Max(value = 5)
	private Integer rating;
	
	private String comments;

	public ProductReviewEntity(Long id, @Min(1) @Max(5) Integer rating, String comments) {
		super();
		Id = id;
		this.rating = rating;
		this.comments = comments;
	}
	
	// No arg constructor
	public ProductReviewEntity() {
		
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	
	

}
