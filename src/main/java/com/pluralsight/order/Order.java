package com.pluralsight.order;

import com.pluralsight.utils.IPrice;
import com.pluralsight.utils.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Order implements IPrice {

    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chips;

    private LocalDateTime checkoutTime;
    private double orderTotalPrice;

    public Order(List<Sandwich> sandwiches, List<Drink> drinks, List<Chips> chips) {
        this.sandwiches = sandwiches;
        this.drinks = drinks;
        this.chips = chips;
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public void setSandwiches(List<Sandwich> sandwiches) {
        this.sandwiches = sandwiches;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    public List<Chips> getChips() {
        return chips;
    }

    public void setChips(List<Chips> chips) {
        this.chips = chips;
    }

    //TODO @AKHIL finish this method with proper logic
    public void addSandwichToOrder(Sandwich sandwich){
        sandwiches.add(sandwich);

    }
    //TODO @AKHIL finish this method with proper logic
    public void addDrinkToOrder(Drink drink){
        drinks.add(drink);

    }
    //TODO @AKHIL finish this method with proper logic
    public void addChipsToOrder(Chips chip){
        chips.add(chip);

    }

    //TODO @AKHIL finish this method with proper logic
    public void removeSandwichToOrder(Sandwich sandwich){
        sandwiches.remove(sandwich);

    }
    //TODO @AKHIL finish this method with proper logic
    public void removeDrinkToOrder(Drink drink){
        drinks.remove(drink);

    }
    //TODO @AKHIL finish this method with proper logic
    public void removeChipsToOrder(Chips chip){
        chips.remove(chip);


    }


    public void orderCheckout(){
        checkoutTime = LocalDateTime.now();
    }


    //TODO @AKHIL finish this method with proper logic
    @Override
    public double getPrice(Size size) {
        return 0;
    }
}
