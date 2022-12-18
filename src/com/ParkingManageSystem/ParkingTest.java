package com.ParkingManageSystem;
import java.util.Scanner;

import static java.lang.System.exit;

public class ParkingTest {
    public static void main(String[] args) throws Exception {
        ParkingManage PM = new ParkingManage();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("========欢迎来到停车场收费系统========");
            System.out.println("请选择要进行的操作：");
            System.out.println("1、车辆进入停车场");
            System.out.println("2、车辆驶出停车场");
            System.out.println("3、统计停车场开业也来的总收入");
            System.out.println("4、当前可用车位情况");
            System.out.println("5、停车场当天收入");
            System.out.println("6、退出系统");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    //车辆进入停车场
                    System.out.println("请输入车牌号：");
                    String lpn = sc.next();
                    PM.enterParking(lpn);
                    break;
                case 2:
                    //车辆驶出停车场
                    System.out.println("请输入车牌号：");
                    String lpn1 = sc.next();
                    PM.outParking(lpn1);
                    break;
                case 3:
//                    统计停车场开业也来的总收入
                    System.out.println("停车场开业也来的总收入"+PM.totalCost()+"元");
                    break;
                case 4:
                    //当前可用车位情况
                    PM.show();
                    break;
                case 5:
//                    停车场当天收入
                    System.out.println("当天收入"+PM.TodayIncome()+"元");
                    break;
                case 6:
                    System.out.println("正在退出系统。。。");
                    exit(0);
                default:
                    System.out.println("输入错误，请重新输入");
            }
        }


    }
}
