package com.aslam.mycontact.catelog.daolayer.catelog.Pricing;

public class Price implements PriceV1{

    private Double pricePerItem;


    public Price(Double pricePerItem) {
        this.pricePerItem = pricePerItem;
    }

    public Price() {
    }


    public Double getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(Double pricePerItem) {
        this.pricePerItem = pricePerItem;
    }
}
