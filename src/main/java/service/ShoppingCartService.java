package main.java.service;

import main.java.model.Cart;
import main.java.model.Item;
import main.java.model.PromoCode;
import main.java.model.PromoCodeType;

import java.util.List;
import java.util.Optional;

public class ShoppingCartService {
    public void addItem(Cart cart, String itemId) {
        //getItemById()
        Item item = getItemById(itemId);
        //add item to cart
        cart.getItems().add(item);
        //caculate total and update in cart
        double total = cart.getTotal();
        total += item.getPrice();
        cart.setTotal(total);
    }

    public void addItem2(Cart cart, String itemId) {
        Optional<Item> existingItemOpt = cart.getItems().stream()
                .filter(item -> item.getId().equals("Item" + itemId)).findFirst();

        double total = cart.getTotal();

        if (existingItemOpt.isPresent()) {
            Item existingItem = existingItemOpt.get();
            existingItem.incrementQuantity();
            //update total
            total += existingItem.getPrice();
        } else {
            Item newItem = getItemById(itemId);
            cart.getItems().add(newItem);
            //update total
            total += newItem.getPrice();
        }
        //Update total amount in cart
        cart.setTotal(total);
    }

//    public void removeItem(Cart cart, String itemId) {
//        Optional<Item> existingItemOpt = cart.getItems().stream()
//                .filter(item -> item.getId().equals("Item" + itemId)).findFirst();
//
//        if (existingItemOpt.isPresent()) {
//            Item existingItem = existingItemOpt.get();
//            double total = cart.getTotal();
//            //decrement quantity or remove item from cart
//            if (existingItem.getQuantity() > 1) {
//                existingItem.decrementQuantity();
//            } else {
//                cart.getItems().remove(existingItem);
//            }
//            //update total
//            total -= existingItem.getPrice();
//            cart.setTotal(total);
//        } else {
//            System.out.println("Item not found in cart");
//        }
//    }

    private Item getItemById(String itemId) {
        return new Item("Item" + itemId, Integer.valueOf(itemId));
    }


    public void applyPromoCode(Cart cart, String code) {
        //get promo-code by code
        PromoCode promoCode = getPromoCodeByCode(code);
        //apply discount as per type and get total
        double total = applyDiscount(promoCode, cart.getTotal());
        //set total in cart and add promo-code
        cart.setTotal(total);
        cart.getPromoCodes().add(promoCode);
        cart.getTraceCodes().add(code);
    }
//    public void removePromoCode(Cart cart, String code) {
//        Optional<PromoCode> existingPromoOpt = cart.getPromoCodes().stream()
//                .filter(p -> p.getCode().equals(code)).findFirst();
//
//        if (existingPromoOpt.isPresent()) {
//            PromoCode promoCode = existingPromoOpt.get();
//            //decrement quantity or remove item from cart
//            cart.getTraceCodes().remove(code);
//            cart.getPromoCodes().remove(code);
//            reCalculateTotal(cart);
//        } else {
//            System.out.println("PromoCode not found in cart");
//        }
//    }

//    public void reCalculateTotal(Cart cart){
//        List<String> traceCodes = cart.getTraceCodes();
//        for(String request: cart.getTraceCodes()){
//            if(request.startsWith("Item")) addItem(cart, request);
//            else applyPromoCode(cart, request);
//        }
//    }

    private double applyDiscount(PromoCode promoCode, double total) {
        if (promoCode.getType() == PromoCodeType.PERCENTAGE) {
            return total - total * promoCode.getDiscount() / 100;
        } else if (promoCode.getType() == PromoCodeType.AMOUNT) {
            return total - promoCode.getDiscount();
        }
        return total;
    }

    private PromoCode getPromoCodeByCode(String code) {
        PromoCodeType type;
        //identify type of promo-code
        if (code.charAt(0) == 'p') type = PromoCodeType.PERCENTAGE;
        else type = PromoCodeType.AMOUNT;
        //get discount from code
        double discount = Double.valueOf(code.substring(1));
        return new PromoCode(code, type, discount);
    }
}
