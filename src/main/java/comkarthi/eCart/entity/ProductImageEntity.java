package comkarthi.eCart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_Image")
public class ProductImageEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String publicId;
	private String url;
	
	public ProductImageEntity(Long id, String publicId, String url) {
		super();
		Id = id;
		this.publicId = publicId;
		this.url = url;
	}
	
	
	public ProductImageEntity() {
		super();
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getPublicId() {
		return publicId;
	}


	public void setPublicId(String publicId) {
		this.publicId = publicId;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	
}
