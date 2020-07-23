package hu.misi.feladat.service.impl;

import hu.misi.feladat.core.model.Product;
import hu.misi.feladat.core.model.User;
import hu.misi.feladat.core.service.IProductSerivce;
import hu.misi.feladat.service.dao.ProductDao;

import java.util.Collection;

public class ProductService implements IProductSerivce {
    private ProductDao dao;

    public ProductService(ProductDao dao) {
        this.dao = dao;
    }

    public Collection<Product> getProducts() {
        return dao.getProducts();
    }

    public Collection<Product> getProductsByUserId(User user) {
        return dao.getProductsByUserId(user);
    }

    public Product getProductById(int id) {
        return dao.getProductById(id);
    }

    public Product addProduct(Product newProduct, int userId) {
        return dao.addProduct(newProduct,userId);
    }

    public boolean modifyProduct(Product product) {
        return dao.modifyProduct(product);
    }

    public boolean deleteProductById(int id) {
        return dao.deleteProductById(id);
    }
}