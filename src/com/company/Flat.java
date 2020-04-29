package com.company;

import java.io.File;

public class Flat {
    private int numberOfRooms;
    private double square;

    public Flat() {
        numberOfRooms = 0;
        square = 0;
    }

    public Flat(int numberOfRooms, double square){
        this.square=square;
        this.numberOfRooms=numberOfRooms;
    }

    public double getSquare() {
        return square;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    @Override
    public String toString() {
        return "numberOfRooms=" + numberOfRooms + ", square=" + square;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flat)) return false;
        Flat flat = (Flat) o;
        if (numberOfRooms != flat.numberOfRooms) return false;
        return Double.compare(flat.square, square) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = numberOfRooms;
        temp = Double.doubleToLongBits(square);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
