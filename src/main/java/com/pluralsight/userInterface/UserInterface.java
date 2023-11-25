package com.pluralsight.userInterface;

import com.pluralsight.order.Chips;
import com.pluralsight.order.Drink;
import com.pluralsight.order.Order;
import com.pluralsight.order.Sandwich;

import java.util.ArrayList;
import java.util.List;

public class UserInterface {
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chips> chips = new ArrayList<>();



    public UserInterface() {
    }

    public void HomeMenu(){

    }
    public void addSandwichMenu(){

    }

    public void addDrinkMenu(){

    }

    public void addChipsMenu(){

    }

    public void processAddSandwichToOrder(Sandwich sandwich){

    }

    public void processAddDrinkToOrder(Drink drink){

    }

    public void processAddChipsToOrder(Chips chips){

    }

    public void processRemoveSandwichFromOrder(Sandwich sandwich){

    }

    public void processRemoveDrinkFromOrder(Drink drink){

    }

    public void processRemoveChipsFromOrder(Chips chips){

    }

    public void processCheckout(){
        Order order = new Order(sandwiches,drinks,chips);
    }


}
