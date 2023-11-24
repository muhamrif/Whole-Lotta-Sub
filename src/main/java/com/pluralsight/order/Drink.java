package com.pluralsight.order;

import com.pluralsight.IPrice;
import com.pluralsight.Size;

public class Drink implements IPrice {
    private Size size;
    private String type;

    public Drink(Size size, String type) {
        this.size = size;
        this.type = type;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public double getPrice(Size size) {
        if (size.equals(Size.SMALL)){
            return 2.00;
        }else if(size.equals(Size.MEDIUM)){
            return 2.50;
        }else {
            return 3.00;
        }
    }
}
