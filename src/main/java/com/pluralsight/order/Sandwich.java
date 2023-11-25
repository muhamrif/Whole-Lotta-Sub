package com.pluralsight.order;

import com.pluralsight.utils.IPrice;
import com.pluralsight.utils.Size;

import java.util.List;

public class Sandwich implements IPrice {

    private Bread bread;
    private List<Topping> toppings;
    private Size size;
    private Boolean toasted;

    public Sandwich(Bread bread, List<Topping> toppings, Size size, Boolean toasted) {
        this.bread = bread;
        this.toppings = toppings;
        this.size = size;
        this.toasted = toasted;
    }

    public Bread getBread() {
        return bread;
    }

    public void setBread(Bread bread) {
        this.bread = bread;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Boolean getToasted() {
        return toasted;
    }

    public void setToasted(Boolean toasted) {
        this.toasted = toasted;
    }


    public void removeBread(Bread bread){
        this.bread = new Bread("No Bread");
    }


    public void removeTopping(Topping topping){
        toppings.remove(topping);

    }

    public void addTopping(Topping topping){
        toppings.add(topping);

    }

    @Override
    public double getPrice(Size size) {
        double breadPrice = bread.getPrice(size);
        double toppingPrice = 0.0;
        for (Topping topping : toppings) {
            toppingPrice += topping.getPrice(size);
        }
        return breadPrice + toppingPrice;
    }
}
