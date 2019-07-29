package lesson04HW.model;

import java.util.Arrays;

/**
 * Created by anton.sviatov on 25.07.2019.
 */
public class Order {
    private Integer id;
    private Integer clientID;
    private String dateOfOrder;
    private Integer[] soldGoods;
    private boolean isComplete;

    public Order(Integer id, Integer clientID, String dateOfOrder, Integer[] soldGoods, boolean isComplete) {
        this.id = id;
        this.clientID = clientID;
        this.dateOfOrder = dateOfOrder;
        this.soldGoods = soldGoods;
        this.isComplete = isComplete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public Integer[] getSoldGoods() {
        return soldGoods;
    }

    public void setSoldGoods(Integer[] soldGoods) {
        this.soldGoods = soldGoods;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", clientID=" + clientID +
                ", dateOfOrder='" + dateOfOrder + '\'' +
                ", soldGoods=" + Arrays.toString(soldGoods) +
                '}';
    }

    public String getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(String dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }
}
