package hu.misi.feladat.service.impl;
import hu.misi.feladat.core.model.Product;
import hu.misi.feladat.service.dao.ProductDao;
import org.easymock.EasyMock;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.*;
import hu.misi.feladat.core.model.Role;
import java.util.Arrays;
import java.util.Collection;
import static org.easymock.EasyMock.same;
public class ProductSerivceTest {
    @Mock
    private ProductDao dao;
    @TestSubject
    private ProductService service;
    Collection<Product> dummyDB;
    Product exceptionProduct;
    Product goodUser;
    Product userWithoutAnything;
    @Before
    public void init(){

    }

}
