package com.pluralsight.order;

import com.pluralsight.IPrice;
import com.pluralsight.Size;

public class Topping implements IPrice {

    private String type;

    public Topping(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public double getPrice(Size size) {
        return 0;
    }
}
