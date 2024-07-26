package main.java.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private String id;
    private List<Item> items;
    private List<PromoCode> promoCodes;

    public List<String> getTraceCodes() {
        return traceCodes;
    }

    public void setTraceCodes(List<String> traceCodes) {
        this.traceCodes = traceCodes;
    }

    private List<String> traceCodes;
    private double total;

    public Cart(String id) {
        this.total = 0;
        this.items = new ArrayList<>();
        this.promoCodes = new ArrayList<>();
        this.traceCodes = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<PromoCode> getPromoCodes() {
        return promoCodes;
    }

    public void setPromoCodes(List<PromoCode> promoCodes) {
        this.promoCodes = promoCodes;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
