package com.dhy.superhero;

public class IronMan extends SuperHero{
    public String weapon;
    public IronMan(){}
    public void introduce()
    {
        System.out.println("我是："+name);
        System.out.println("我的武器是："+weapon);
        System.out.println("我的职业是："+occupation);
        System.out.println("我的任务是："+task);
    }
}
