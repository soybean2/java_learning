package com.dhy.superhero;

public class SuperHero {
    public String name;   //姓名
    String occupation;    //职业
    protected String task;   //任务
    private String headquarters;  //指挥部
    public void introduce(){   //简介
        System.out.println("我是："+name);
        System.out.println("我的职业是："+occupation);
        System.out.println("我的任务是："+task);
        System.out.println("我的指挥部是："+headquarters);
    }
    public SuperHero(){}
    public SuperHero(String name,String occupation,String task,String headquarters){
        this.name = name;
        this.occupation=occupation;
        this.task=task;
        this.headquarters=headquarters;
    }
}
