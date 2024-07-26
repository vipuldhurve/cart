package main.java;


import main.java.model.Cart;
import main.java.service.ShoppingCartService;

import java.util.*;


public class Sample {

    public static void main(String[] args) {
        System.out.println("Hello");

        List<String> shoppingRequest = new ArrayList<>(Arrays.asList("1", "10", "p10", "10", "a10"));

        Cart cart = new Cart("cart1");
        ShoppingCartService shoppingCartService = new ShoppingCartService();

        for(String request: shoppingRequest){
            if(Character.isDigit(request.charAt(0))) shoppingCartService.addItem(cart, request);
            else shoppingCartService.applyPromoCode(cart, request);
        }

        System.out.println("Please pay " + cart.getTotal());

    }


}

//---------Cart
//id
//list<Item>
//list<promoCode>
//total

//----------Item
//code
//price
//calculatePrice

//--------PromoCode
//code
//PromoCodeType
//discount

//PromoCodeType
//PERCENTAGE
//AMOUNT