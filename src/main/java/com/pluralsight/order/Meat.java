package com.pluralsight.order;

import com.pluralsight.utils.Size;

public class Meat extends PremiumTopping {
    private Boolean extraMeat;

    public Meat(String type, Boolean extraMeat) {
        super(type);
        this.extraMeat = extraMeat;
    }

    public Boolean getExtraMeat() {
        return extraMeat;
    }

    public void setExtraMeat(Boolean extraMeat) {
        this.extraMeat = extraMeat;
    }

    @Override
    public double getPrice(Size size) {
        double price = 3.00;
        if (size.equals(Size.SMALL)){
            price = 1.00;
        }else if(size.equals(Size.MEDIUM)){
            price =  2.00;
        }

        return extraMeat? price*1.5:price;
    }
}
