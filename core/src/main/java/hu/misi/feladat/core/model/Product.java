package hu.misi.feladat.core.model;
import java.time.LocalDate;
import java.util.regex.Pattern;
import hu.misi.feladat.core.exceptions.*;


import javax.persistence.*;


@Entity
@Table(name="Product")
public class Product {
    public Product() {

    }

    public Product(Integer id, String name, String description, Integer price, Boolean issold, Boolean isaccapted, String imagepath) throws InvalidProductNameException, InvalidProductDescriptionException, InvalidImagePathException {
        setId(id);
        setName(name);
        setDescription(description);
        setPrice(price);
        setIsSold(issold);
        setIsAccapted(isaccapted);
        setImagepath(imagepath);
    }

    public Product(Integer id, String name, String description, Integer price, Boolean issold, Boolean isaccapted, String imagepath,
                   LocalDate created_date, LocalDate sold_date) throws InvalidProductNameException, InvalidProductDescriptionException, InvalidImagePathException {
        this(id, name, description, price, issold, isaccapted, imagepath);
        setCreated_date(created_date);
        setSold_date(sold_date);
    }
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="price")
    private Integer price;
    @Column(name="issold")
    private Boolean issold;
    @Column(name="isaccapted")
    private Boolean isaccapted;
    @Column(name = "imagepath")
    private String imagepath;

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private User owner;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer")
    private User buyer;
    @Column(name = "created_date")
    private LocalDate created_date;
    @Column(name = "sold_date")
    private LocalDate sold_date;

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) throws InvalidImagePathException {
        String regex = "([a-zA-Z]:)?(\\\\[a-zA-Z0-9._-]+)+\\\\?";
        Pattern pattern = Pattern.compile(regex);
        boolean isMatched = Pattern.matches(regex, imagepath);
        if (!isMatched) throw new InvalidImagePathException(imagepath);
        this.imagepath = imagepath;
    }

    public Boolean getIsAccapted() {
        return isaccapted;
    }

    public void setIsAccapted(Boolean isaccapted) {
        this.isaccapted = isaccapted;
    }

    public Boolean getIsSold() {
        return issold;
    }

    public void setIsSold(Boolean issold) {
        this.issold = issold;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws InvalidProductDescriptionException {
        if ("".equals(description)) throw new InvalidProductDescriptionException("Description cannot be empty!");
        else if (description.length() < 10)
            throw new InvalidProductDescriptionException("Description length has to be more than 10 char. Description is " + description);
        else if (description.length() > 255)
            throw new InvalidProductDescriptionException("Description length cannot be more than 255 char. Description is " + description + "(" + description.length() + ")");
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidProductNameException {
        if ("".equals(name)) throw new InvalidProductNameException("Name cannot be empty!");
        else if (name.length() < 3)
            throw new InvalidProductNameException("Name length has to be more than 2 char. Given name is " + name);
        else if (name.length() > 20)
            throw new InvalidProductNameException("Name length cannot be more than 20 char. Given name is " + name + "(" + name.length() + ")");
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDate created_date) {
        this.created_date = created_date;
    }

    public LocalDate getSold_date() {
        return sold_date;
    }

    public void setSold_date(LocalDate sold_date) {
        this.sold_date = sold_date;
    }
}
