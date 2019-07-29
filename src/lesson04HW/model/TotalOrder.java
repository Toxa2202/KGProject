package lesson04HW.model;

import java.util.Date;

/**
 * Created by anton.sviatov on 26.07.2019.
 */
public class TotalOrder {
    private Integer orderId;
    private String name;
    private java.util.Date dateOfOrder;

    public TotalOrder(Integer orderId, String name, Date dateOfOrder) {
        this.orderId = orderId;
        this.name = name;
        this.dateOfOrder = dateOfOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    @Override
    public String toString() {
        return "TotalOrder{" +
                "name='" + name + '\'' +
                ", dateOfOrder='" + dateOfOrder + '\'' +
                '}';
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
