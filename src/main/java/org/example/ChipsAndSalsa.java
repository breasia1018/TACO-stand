package org.example;
public class ChipsAndSalsa {

    private String salsaType;
    private double price;

    public ChipsAndSalsa(String salsaType) {

        this.salsaType = salsaType;
        this.price = calculatePrice();
    }

    public String getSalsaType() {
        return salsaType;
    }

    public double getPrice() {
        return price;
    }

    public double calculatePrice() {
        return 1.50;
    }

    public void display() {

        System.out.println("Chips & Salsa (" + salsaType + ") - $" + String.format("%.2f", price));
    }

    @Override
    public String toString() {

        return "Chips & Salsa (" + salsaType + ") - $" + String.format("%.2f", price);
    }
}
