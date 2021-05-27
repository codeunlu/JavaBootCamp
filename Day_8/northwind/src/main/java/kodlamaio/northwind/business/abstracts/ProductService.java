package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;

public interface ProductService {
	DataResult<List<Product>> getAll();
	Result add(Product product);

	// Database Operasyonları
	// where productname = productname
	DataResult<Product> getByProductName(String productName);

	// where komutunda ve
	DataResult<Product> getByProductNameAndCategory(String productName, int categoryId);

	// where komutunda veya
	DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId);

	// categories id leri varsa (in komutu)
	DataResult<List<Product>> getByCategoryIn(List<Integer> categories);

	// İsmin içinde name içeriyorsa
	DataResult<List<Product>> getByProductNameContains(String productName);

	// Bu isimle başlayanları getir
	DataResult<List<Product>> getByProductNameStartingWith(String productName);

}
