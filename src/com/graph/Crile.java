package com.graph;

public class Crile extends Shape {
    public static final double PI = 3.14;
    private double r;

    public Crile() {
    }

    public Crile(double r){
        this.r=r;
    }
    @Override
    public double area(){
        double r=this.r;
        return r*r*PI;
    }

    @Override
    public double perimeter() {
        return 2*PI*r;
    }

    @Override
    public String toString() {
        return "圆形的面积为" +this.area()+"\t圆形的周长为" +
                this.perimeter();
    }
}
