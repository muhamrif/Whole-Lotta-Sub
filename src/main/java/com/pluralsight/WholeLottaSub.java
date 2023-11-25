package com.pluralsight;

import com.pluralsight.fileManager.OrderFileManager;
import com.pluralsight.order.*;
import com.pluralsight.utils.Size;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WholeLottaSub {
    OrderFileManager orderFileManager = new OrderFileManager();
    public static void main(String[] args) {
        System.out.println("WholeLottaSub");

        //fill in the constructor with the appropriate arguments
        List<Sandwich> sandwiches = new ArrayList<>();
        List<Drink> drinks = new ArrayList<>();
        Drink drink = new Drink(Size.SMALL, "fanta");
        drinks.add(drink);
        List<Chips> chips = new ArrayList<>();
        Chips chip = new Chips("lays");
        chips.add(chip);

        Bread bread = new Bread("wheat");
        List<Topping> toppings = new ArrayList<>();
        Topping topping = new FreeTopping("lettuce");
        toppings.add(topping);
        Topping topping1 = new FreeTopping("tomato");
        toppings.add(topping1);
        Topping topping2 = new Meat("bacon",true);
        toppings.add(topping2);
        Topping topping3 = new Cheese("cheddar",false);
        toppings.add(topping3);
        Sandwich sandwich = new Sandwich(bread,toppings,Size.SMALL,true);
        sandwiches.add(sandwich);
        Order order = new Order(sandwiches, drinks, chips);

        OrderFileManager orderFileManager = new OrderFileManager();
        orderFileManager.saveOrder(order);

    }
}
