package main.java.model;

public class Item {
    private String id;
    private double price;
    private int quantity;

    public Item(String id, double price) {
        this.id = id;
        this.price = price;
        this.quantity = 1;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void incrementQuantity() {
        this.quantity++;
    }

    public int getQuantity() {
        return quantity;
    }

    public void decrementQuantity() {
        if (this.quantity > 0) {
            this.quantity--;
        }
    }
}
