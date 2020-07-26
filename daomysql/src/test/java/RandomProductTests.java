import hu.misi.feladat.core.exceptions.*;
import hu.misi.feladat.core.model.Product;
import hu.misi.feladat.core.model.Role;
import hu.misi.feladat.core.model.User;
import hu.misi.feladat.daomysql.dao.impl.MysqlProductDao;
import hu.misi.feladat.daomysql.dao.impl.MysqlUserDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Collection;
public class RandomProductTests {

    MysqlProductDao dao = new MysqlProductDao();
    MysqlUserDAO userDAO = new MysqlUserDAO();
    @Test
    public void getProducts(){
        Collection<Product> products = dao.getProducts();
        for (Product product:products
                ) {
            System.out.println(product.getName());
        }
    }
    @Test
    public void getProductsAuth(){
        Collection<Product> products = dao.getAuthorizedProducts();
        for (Product product:products
                ) {
            System.out.println(product.getName());
        }
    }
    @Test
    public void getProductsNotAuth(){
        Collection<Product> products = dao.getNotAuthorizedProducts();
        for (Product product:products
                ) {
            System.out.println(product.getName());
        }
    }

    public void addProduct() throws InvalidProductNameException, InvalidProductDescriptionException, InvalidImagePathException, InvalidUsernameException, InvalidEmailException, InvalidPassword, InvalidRealnameException {
        Product newProduct = new Product();
        newProduct.setName("Hibernate");
        newProduct.setCreated_date(LocalDate.now());
        newProduct.setDescription("Első kapcsolótáblás hozzáadás");
        newProduct.setImagepath("C:\\imagePAth");
        newProduct.setIsAccapted(false);
        newProduct.setIsSold(false);
        newProduct.setPrice(10000);
        Product meow = dao.addProduct(newProduct,2);
    }
    @Test
    public void getUserProducts(){
        User user = userDAO.getUserById(2);
        Collection<Product> products = dao.getProductsByUserId(user);
        for (Product product:products
                ) {
            System.out.println(product.getName());
        }
    }
}
