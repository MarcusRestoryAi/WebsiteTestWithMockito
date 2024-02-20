package org.example;

public class Rektangel {

    public int length;
    public int width;

    public Rektangel(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public void setSize(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getArea() {
        return length * width;
    }

    public boolean isSquare() {
        return length == width;
    }
}
