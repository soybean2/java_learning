package com.goods;

public class Clothing extends Goods implements VipPrice{
    private String style;

    public Clothing(int unitPrice, int account, String style) {
        super(unitPrice, account);
        this.style = style;
    }

    @Override
    public double reducedPrice() {
        return DISCOUNT*super.totalPrice();
    }

    @Override
    public String toString() {
        return "衣服的样式为:"+style+"\t衣服的数量为"+this.getAccount()+"\t衣服的单价为"+
                this.getUnitPrice()+"\t衣服的总价为:"+totalPrice()+"\t打折后的价格为:"+reducedPrice();
    }
}
