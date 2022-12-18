package com.ParkingManageSystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

public class ParkingManage {
    private ArrayList<Car> cars= new ArrayList<>();//到本停车场停过的车
    private final int maxNumber = 100;//停车场最大容量；
    private static int currentNumber;//停车场当前停车数

    public ParkingManage() {
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }


    public int getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(int currentNumber) {
        this.currentNumber = currentNumber;
    }

    public void enterParking(String lpn) throws ParseException {
        if (hasPosition()){
            if(searchCar(lpn)==null)
            {
                System.out.println(lpn+"进入停车场");
                currentNumber++;
                Car car = new Car(lpn);
                car.enter();
                cars.add(car);
            }else{
                System.out.println("车辆已在停车场");
            }
        }else{
            System.out.println("车辆已满！");
        }
        //车辆进入停车场
    }
    public void outParking(String lpn) throws Exception {
        //车辆驶离停车场
        if(searchCar(lpn)!=null){
            Car c =  searchCar(lpn);
            if (c.isParking()){
                System.out.println(lpn+"驶离停车场");
                c.out();
                int cost = c.calculateCost();
                System.out.println("停车花费"+cost+"元");
                currentNumber--;
            }else{
                System.out.println("车辆已离开停车场");
            }

        }else{
            System.out.println("车辆不在停车场");
        }
    }
    public int totalCost() throws Exception {
        int cost = 0;
        for (Car c:cars) {
            Car c1 = searchCar(c.getLpn());
            cost += c1.calculateCost();
        }
        return cost;
    }
    public boolean hasPosition(){
        //当前是否还有停车位
        if(currentNumber>=maxNumber)
            return false;
        else
            return true;
    }

    public Car searchCar(String lpn){
        //搜索当前系统中是否存在此车信息
        for (Car c:cars) {
            if (c.getLpn().equals(lpn))
                return c;
        }
        return null;
    }
    public int TodayIncome() throws Exception {
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(today);
        Date parse = sdf.parse(format);
        int sum = 0;
        for (Car c:cars) {
            CarParking temp = c.getParkings().get(c.getParkings().size() -1);
            if(temp.getOutDate().getTime()>parse.getTime()){
                sum += c.calculateCost();
            }
        }
        return sum;
    }
    public void show(){
        //进行一些简单的统计并输出结果
        System.out.println("当前停车场有"+currentNumber+"辆车,剩余"+(maxNumber-currentNumber)+"个车位");
        System.out.println("正在停车场的车辆信息如下：");
        Iterator<Car> i = cars.iterator();
        while (i.hasNext()) {
            Car temp = i.next();
            if (temp.isParking()){
                System.out.print(temp.getLpn() + "; ");
            }
        }
    }
}
