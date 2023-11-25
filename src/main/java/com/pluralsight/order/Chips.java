package com.pluralsight.order;

import com.pluralsight.utils.IPrice;
import com.pluralsight.utils.Size;

public class Chips implements IPrice {
    private String type;

    public Chips(String type) {
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
        return 1.50;
    }

    @Override
    public String toString() {
        return "1 X Chips $" + getPrice(Size.SMALL) + "\n" +
                "Brand: " + type + "\n";
    }
}
