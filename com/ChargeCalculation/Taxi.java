package com.ChargeCalculation;

public class Taxi implements Charge{
    private int distance;

    public Taxi(int distance) {
        this.distance = distance;
    }

    @Override
    public int receive() {

        return (int) (10+0.4*distance);
    }
}
