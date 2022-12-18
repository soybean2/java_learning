package com.ParkingManageSystem;

import java.util.Date;

public class CarParking{
    private int no;//停车序号
    private int cost;//本次停车收费
    private Date enterDate;//车辆进入停车场的时间
    private Date outDate;//车辆驶离停车场的时间

    public CarParking() {}

    public CarParking(int cost, Date enterDate, Date outDate) {
        this.no = no;
        this.cost = cost;
        this.enterDate = enterDate;
        this.outDate = outDate;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Date getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

}
