package org.example.electronicdevices;

public class Tablet extends Device{
    protected double batteryLife;
    protected boolean hasStylus;

    public Tablet() {}

    public Tablet(Devicetype type, String name, double price, double weight) {
        super(type, name, price, weight);
    }

    public Tablet(Devicetype type, String name, double price, double weight, double batteryLife, boolean hasStylus) {
        super(type, name, price, weight);
        this.batteryLife = batteryLife;
        this.hasStylus = hasStylus;
    }

    public double getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(double batteryLife) {
        this.batteryLife = batteryLife;
    }

    public boolean isHasStylus() {
        return hasStylus;
    }

    public void setHasStylus(boolean hasStylus) {
        this.hasStylus = hasStylus;
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "type=" + type +
                ", name= '" + name + '\'' +
                ", price=" + price + "$" +
                ", weight=" + weight +
                ", batteryLife=" + batteryLife +
                ", hasStylus=" + hasStylus +
                '}';
    }
}
