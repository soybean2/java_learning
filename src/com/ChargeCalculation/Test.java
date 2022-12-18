package com.ChargeCalculation;

public class Test {
    public static void main(String[] args) {
        Bus bus = new Bus();
        System.out.println(bus.receive());
        Taxi taxi = new Taxi(5);
        System.out.println(taxi.receive());
        Cinema cinema = new Cinema();
        System.out.println(cinema.receive());
    }
}
