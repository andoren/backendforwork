package hu.misi.feladat.core.service;

import hu.misi.feladat.core.model.Product;
import hu.misi.feladat.core.model.User;

import java.util.Collection;

public interface IProductSerivce {
    Collection<Product> getProducts();
    Collection<Product> getProductsByUserId(User user);
    Product getProductById(int id);
    Product addProduct(Product newProduct, int userId);
    boolean modifyProduct(Product product);
    boolean deleteProductById(int id);
}
