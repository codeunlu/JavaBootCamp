package kodlamaio.northwind.dataAccess.abstracts;

import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer>{
    // where productname = productname
    Product getByProductName(String productName);

    // where komutunda ve
    Product getByProductNameAndCategory(String productName, int categoryId);

    // where komutunda veya
    List<Product> getByProductNameOrCategory(String productName, int categoryId);

    // categories id leri varsa (in komutu)
    List<Product> getByCategoryIn(List<Integer> categories);

    // İsmin içinde name içeriyorsa
    List<Product> getByProductNameContains(String productName);

    // Bu isimle başlayanları getir
    List<Product> getByProductNameStartingWith(String productName);

    // Kendimiz query yazmak istersek (JPQL)
    // Entitiy de yer alan alana göre yapılır
    @Query("From Product where productName=:productName and category.categoryId=:categoryId")
    List<Product> getByNameAndCategory(String productName, int categoryId);

    @Query("select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) from Category c INNER join c.products p")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();
	
}

