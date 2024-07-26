package main.java.model;

public class PromoCode {
    private String code;
    private PromoCodeType type;
    private double discount;

    public PromoCode(String code, PromoCodeType type, double discount) {
        this.code = code;
        this.type = type;
        this.discount = discount;
    }

    public String getCode() {
        return code;
    }

    public PromoCodeType getType() {
        return type;
    }

    public double getDiscount() {
        return discount;
    }
}
