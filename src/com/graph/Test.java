package com.graph;

public class Test {
    public static void main(String[] args) {
        Shape r = new Rectangular(2, 3);
        Shape c = new Crile(3);
        Shape t = new Triangle(3,4);
        System.out.println(r);
        System.out.println(c);
        System.out.println(t);
    }
}
