package com.zoon;

public class Fish extends Animal implements Food{
    public void eat() {
        System.out.println(mouth+"吃海里的东西");
    }
    @Override
    public void cook() {
        System.out.println("可以烧酸菜鱼");
    }
}
