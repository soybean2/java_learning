package com.zoon;

public class Cat extends Animal{
    @Override
    public void eat() {
        System.out.println(mouth +"吃鱼");
    }
    @Override
    public void shout()
    {
        System.out.println(mouth+"叫喵喵");
    }
}
