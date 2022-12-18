package com.dhy.superhero;

public class Test {
    public static void main(String[] args) {
        SuperHero hero = new SuperHero("超级英雄","维护世界和平","打败洛基","S.H.I.E.L.D");
        hero.introduce();
        IronMan ironMan = new IronMan();
        ironMan.weapon = "钢铁盔甲";
        ironMan.name = "钢铁侠";
        ironMan.occupation="维护世界和平";
        ironMan.task="打败洛基";
        ironMan.introduce();
        Hulk hulk = new Hulk();
        hulk.name = "绿巨人";
        hulk.occupation="维护世界和平";
        hulk.task="打败洛基";
        hulk.introduce();
    }
}
