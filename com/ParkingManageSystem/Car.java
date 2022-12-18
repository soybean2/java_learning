package com.ParkingManageSystem;

import java.awt.print.PrinterException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class Car {
    private String lpn;//车牌号
    private ArrayList<CarParking> parkings;//车辆在停车场停车记录

    public Car() {}

    public Car(String lpn) {
        this.lpn = lpn;
        if (parkings == null)
            parkings = new ArrayList<CarParking>();
    }

    public String getLpn() {
        return lpn;
    }

    public void setLpn(String lpn) {
        this.lpn = lpn;
    }

    public ArrayList<CarParking> getParkings() {
        return parkings;
    }

    public void setParkings(ArrayList<CarParking> parkings) {
        this.parkings = parkings;
    }

    public int calculateCost() throws Exception {
//        计算本次停车费用
        int cost = 0;
        CarParking temp = parkings.get(parkings.size() - 1);
        long time = temp.getOutDate().getTime()-temp.getEnterDate().getTime();
        double h = time/1000/60/60;
        if(time <= 1){
            cost =  3;
        }else{
            cost = 3 + (int)(time - 1) * 2;
        }
        temp.setCost(cost);
        return cost;

    }
    public void enter() throws ParseException {
        //车辆进入停车场
        CarParking carParking = new CarParking();
        System.out.println("请输入进入时间（输入格式yyyy-MM-dd hh:mm:ss）");
        Scanner sc = new Scanner(System.in);
        String time = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date d1 = sdf.parse(time.trim());
        carParking.setEnterDate(d1);
        carParking.setNo(parkings.size() + 1);
        parkings.add(carParking);

    }
    public void out() throws ParseException {
        //车辆离开停车场
        CarParking temp = parkings.get(parkings.size() - 1);
        System.out.println("请输入时间（输入格式yyyy-MM-dd hh:mm:ss）");
        Scanner sc = new Scanner(System.in);
        String time1 = sc.nextLine();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date d2 = sdf.parse(time1.trim());
        temp.setOutDate(d2);
    }

    public  boolean isParking() {
        CarParking temp = parkings.get(parkings.size() -1);
        if (temp.getOutDate() != null)
            return false;
        return true;
    }
    @Override
    public String toString() {
        int num = parkings.size(); // 该车有多少次停车记录
        StringBuffer sb = new StringBuffer();
        sb.append("车牌:" + lpn + ",共有" + num + "次停车记录，分别是：");
        Iterator<CarParking> i = parkings.iterator(); // 对列表进行遍历
        while (i.hasNext()) {
            CarParking temp = i.next();
            sb.append(temp + "\n");
        }
        if (isParking()){
            sb.append("目前该车还在停车场。");
        }else{
            sb.append("目前该车不在停车场。");
        }
        return sb.toString();
    }
}
