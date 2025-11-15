package comkarthi.eCart.Seeder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import comkarthi.eCart.entity.ProductEntity;
import comkarthi.eCart.repository.ProductRepository;

// This component runs automatically when the Spring Boot application starts.
// Used to insert demo data (sample products) into the database 
// only if the database is empty, to avoid duplicate entries.
@Component
public class CreateData implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        if (productRepository.count() == 0) {

            List<ProductEntity> demoProducts = List.of(
                new ProductEntity(null, "Apple iPhone 15", 799.0, "SmartPhone with A16 Chip", "Phones", 4.8, "Amazon", 5, 0),
                new ProductEntity(null, "Samsung Galaxy S24", 699.0, "Flagship Android phone", "Phones", 4.7, "Flipkart", 10, 0),
                new ProductEntity(null, "Sony WH-1000XM5", 349.99, "Noise-cancelling headphones", "Audio", 4.6, "Reliance Digital", 6, 0),
                new ProductEntity(null, "Dell XPS 13", 999.99, "Ultrabook with Intel i7", "Laptops", 4.5, "Amazon", 8, 0),
                new ProductEntity(null, "Nike Air Max", 129.99, "Running shoes with air cushioning", "Footwear", 4.4, "Nike Store", 15, 0),
                new ProductEntity(null, "Wooden Study Table", 249.99, "Solid wood desk", "Furniture", 4.3, "Urban Ladder", 12, 0),
                new ProductEntity(null, "Gaming Mouse", 49.99, "RGB mouse with high DPI", "Electronics", 4.7, "Amazon", 30, 0),
                new ProductEntity(null, "Men's Casual Shirt", 19.99, "Cotton shirt for daily wear", "Clothing", 4.2, "Myntra", 50, 0),
                new ProductEntity(null, "Yoga Mat", 29.99, "Non-slip mat for workouts", "Fitness", 4.5, "Decathlon", 40, 0),
                new ProductEntity(null, "Kindle Paperwhite", 139.99, "E-reader with warm light", "Electronics", 4.8, "Amazon", 6, 0)
            );

            productRepository.saveAll(demoProducts);
            System.out.println("Products inserted successfully!");
        } else {
            System.out.println("Data already exists in database.");
        }
    }
}
