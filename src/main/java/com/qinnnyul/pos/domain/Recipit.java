package com.qinnnyul.pos.domain;

public class Recipit {

    private double totalPrice;
    private double originalTotalPrice;

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getOriginalTotalPrice() {
        return originalTotalPrice;
    }

    public void setOriginalTotalPrice(double originalTotalPrice) {
        this.originalTotalPrice = originalTotalPrice;
    }
}
