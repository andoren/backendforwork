package hu.misi.feladat.service.impl;
import com.sun.org.apache.xalan.internal.xsltc.dom.ExtendedSAX;
import hu.misi.feladat.core.exceptions.InvalidImagePathException;
import hu.misi.feladat.core.exceptions.InvalidProductDescriptionException;
import hu.misi.feladat.core.exceptions.InvalidProductNameException;
import hu.misi.feladat.core.model.Product;
import hu.misi.feladat.core.model.User;
import hu.misi.feladat.service.dao.IProductDao;
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
    private IProductDao dao;
    @TestSubject
    private ProductService service;
    Collection<Product> dummyDB;
    Collection<Product> noAuthdummyDB;
    Product goodProduct;
    Product productWithoutAnything;
    User user;
    @Before
    public void init() throws InvalidProductDescriptionException, InvalidImagePathException, InvalidProductNameException {
        dao = EasyMock.niceMock(IProductDao.class);
        this.service = new ProductService(dao);
        goodProduct = new Product();
        productWithoutAnything = new Product();
        dummyDB = Arrays.asList(
                new Product(1,"Eladó macska","Lorem ipsum jo volna ide de nincs kedvem kiváltani az IDE-ből :=(",100,false,false,"c:\\uploadedimage3.jpg"),
                new Product(3,"Eladó macska","Lorem ipsum jo volna ide de nincs kedvem kiváltani az IDE-ből :=(",100,false,false,"c:\\uploadedimage2.jpg"),
                new Product(4,"Eladó macska","Lorem ipsum jo volna ide de nincs kedvem kiváltani az IDE-ből :=(",100,false,false,"c:\\uploadedimage4.jpg")
        );
        noAuthdummyDB = Arrays.asList(
                new Product(2,"Eladó macska","Lorem ipsum jo volna ide de nincs kedvem kiváltani az IDE-ből :=(",100,false,false,"c:\\uploadedimage.jpg")
        );
        EasyMock.expect(dao.addProduct(same(goodProduct),same(1))).andReturn(goodProduct).anyTimes();
        EasyMock.expect(dao.deleteProductById(1)).andReturn(true).anyTimes();
        EasyMock.expect(dao.getNotAuthorizedProducts()).andReturn(noAuthdummyDB).anyTimes();
        EasyMock.expect(dao.getProductsByUserId(same(user))).andReturn(Arrays.asList(new Product())).anyTimes();
        EasyMock.expect(dao.getProducts()).andReturn(dummyDB).anyTimes();
        EasyMock.expect(dao.modifyProduct(same(goodProduct))).andReturn(true).anyTimes();
        EasyMock.expect(dao.getProductById(same(1))).andReturn(goodProduct).anyTimes();
        EasyMock.replay(dao);
    }
    @Test
    public void addProduct(){
        Product product = service.addProduct(goodProduct,1);
        Assert.assertEquals(product,goodProduct);

    }
    @Test
    public void deleteProductById(){
       boolean result =  service.deleteProductById(1);
       Assert.assertEquals(true,result);
    }
    @Test
    public void getNotAuthorizedProducts(){
        Collection<Product> noauth = service.getNotAuthorizedProducts();
        Assert.assertEquals(noAuthdummyDB.size(),noauth.size());
    }
    @Test
    public void getProducts(){
       Collection<Product> products =  service.getProducts();
        Assert.assertEquals(dummyDB,products);
    }
    @Test
    public void getProductsByUserId(){
       Collection<Product> userProducts =  service.getProductsByUserId(user);
       Assert.assertEquals(1,userProducts.size());
    }
    @Test
    public void modifyPrdocut(){
       boolean result =  service.modifyProduct(goodProduct);
       Assert.assertEquals(result,true);
    }
    @Test
    public void getProductById(){
        Product product = service.getProductById(1);
        Assert.assertEquals(goodProduct,product);
    }
}
