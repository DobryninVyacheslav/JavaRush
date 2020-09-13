package ru.lvl19.task6;

public enum TestEnum {
    KEK(5,20),
    LOL(10,40);

    private double x;
    private double y;

    TestEnum(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
