package com.game;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("=======猜字符游戏=======");
        Game g = new Game();
        char[] zifu = g.generate();//随机生成字符串
        String guess = new String(zifu);
        System.out.println(guess);
        while (true) {
            System.out.println("请输入5个不区分大小写的英文字母:(用“EXIT”或exit退出)");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine().trim().toLowerCase();//输入字符串并去除空格和转化成小写
            if (input.equals("exit")) {
                System.out.println("游戏结束，您当前的分数为：" + g.score);
                break;
            }
            if (input.length() == 5 && input.matches("[a-z]+")) {
                //输入正确，计算分数
                int mark = g.calscore(guess, input);
                if (mark == 10) {
                    System.out.println("猜对了");
                    System.out.println("游戏结束，您当前的分数为：" + g.score);
                    break;
                } else {
                    System.out.println("猜错了,猜对的字符为:" + g.guessCharTrue + ",既猜对字符又猜对位置个数：" + g.indexAndCharTrue);
                }
            } else {
                //输入错误
                System.out.println("输入错误，请重新输入：");
            }
        }
    }
}



