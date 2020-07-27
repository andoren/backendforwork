package hu.misi.feladat.service.dao;

import hu.misi.feladat.core.model.Product;
import hu.misi.feladat.core.model.User;

import javax.ejb.Local;
import java.util.Collection;
@Local
public interface IProductDao {
    Collection<Product> getProducts();
    Collection<Product> getProductsByUserId(User user);
    Collection<Product> getNotAuthorizedProducts();
    Collection<Product> getAuthorizedProducts();
    Product getProductById(int id);
    Product addProduct(Product newProduct, int userId);
    boolean modifyProduct(Product product);
    boolean deleteProductById(int id);
}
