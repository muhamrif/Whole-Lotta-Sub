package com.pluralsight.order;

import com.pluralsight.Size;

public class Cheese extends PremiumTopping {
    private Boolean extraCheese;

    public Cheese(String type, Boolean extraCheese) {
        super(type);
        this.extraCheese = extraCheese;
    }

    public Boolean getExtraCheese() {
        return extraCheese;
    }

    public void setExtraCheese(Boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    @Override
    public double getPrice(Size size) {
        double price = 2.25;
        if (size.equals(Size.SMALL)){
            price = .75;
        }else if(size.equals(Size.MEDIUM)){
            price =  1.5;
        }

        return extraCheese? price+(price/2.5):price;
    }
}
