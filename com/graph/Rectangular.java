package com.graph;

public class Rectangular extends Shape {
    private double width;
    private double height;
    public Rectangular() {
    }
    public Rectangular(double width, double height) {
        this.width = width;
        this.height = height;
    }
    @Override
    public double area(){
        double width = this.width;
        double height = this.height;
        return width*height;
    }

    @Override
    public double perimeter() {
        return 2*(width+height);
    }

    @Override
    public String toString() {
        return "矩形的面积为" +this.area()+"\t矩形的周长为" +
                this.perimeter();
    }
}
