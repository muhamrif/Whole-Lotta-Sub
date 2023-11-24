package com.pluralsight.order;

import com.pluralsight.IPrice;
import com.pluralsight.Size;

public class Bread implements IPrice {
    private String type;

    public Bread(String type) {
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
       if (size.equals(Size.SMALL)){
           return 5.50;
       }else if(size.equals(Size.MEDIUM)){
           return 7.00;
       }else {
           return 8.50;
       }
    }
}
