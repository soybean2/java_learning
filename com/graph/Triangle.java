package com.graph;

public class Triangle extends Shape {
    private double height;
    private double bottom;

    public Triangle() {
    }

    public Triangle(double h, double b){
        this.height=h;
        this.bottom=b;
    }
    @Override
    public double area(){
        double h=this.height;
        double b=this.bottom;
        return h*b/2;
    }

    @Override
    public double perimeter() {
        return 2*Math.sqrt(Math.pow(height,2)+Math.pow(bottom/2.0,2))+bottom;
    }

    @Override
    public String toString() {
            return "三角形的面积为" +this.area()+"\t三角形的周长为" +
                    this.perimeter();
    }
}
