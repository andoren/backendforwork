package hu.misi.feladat.service.dao;

import hu.misi.feladat.core.model.Product;
import hu.misi.feladat.core.model.User;

import java.util.Collection;

public interface IProductDao {
    Collection<Product> getProducts();
    Collection<Product> getProductsByUserId(User user);
    Collection<Product> getNotAuthorizedProducts();
    Product getProductById(int id);
    Product addProduct(Product newProduct, int userId);
    boolean modifyProduct(Product product);
    boolean deleteProductById(int id);
}
