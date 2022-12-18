package com.goods;

public class Goods {
    private double unitPrice;
    private int account;

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public Goods() {
    }
    public Goods(double unitPrice, int account) {
        this.unitPrice = unitPrice;
        this.account = account;
    }
    public double totalPrice()
    {
        return unitPrice*account;
    }
}