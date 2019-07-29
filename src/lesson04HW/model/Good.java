package lesson04HW.model;

/**
 * Created by anton.sviatov on 24.07.2019.
 */
public class Good {
    private Integer id;
    private String name;
    private String model;
    private Integer price;
    private Integer quantity;
    private TypeOfGoods typeOfGoods;

    public Good(Integer id, String name, String model, Integer price, Integer quantity, TypeOfGoods typeOfGoods) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.price = price;
        this.quantity = quantity;
        this.typeOfGoods = typeOfGoods;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public TypeOfGoods getTypeOfGoods() {
        return typeOfGoods;
    }

    public void setTypeOfGoods(TypeOfGoods typeOfGoods) {
        this.typeOfGoods = typeOfGoods;
    }

    @Override
    public String toString() {
        return "Good{" + typeOfGoods +
                ", id= " + id +
                ", '" + name + '\'' +
                ", '" + model + '\'' +
                ", price= " + price +
                ", quantity= " + quantity +
                '}';
    }
}
