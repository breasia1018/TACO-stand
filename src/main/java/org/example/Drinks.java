package org.example;

public class Drinks {

    // Fields
    private String size;
    private String flavor;
    private double price;

    // Constructor
    public Drinks(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
        this.price = calculatePrice();
    }

    // Getters
    public String getSize() {
        return size;
    }

    public String getFlavor() {
        return flavor;
    }

    public double getPrice() {
        return price;
    }

    // Setters
    public void setSize(String size) {
        this.size = size;
        this.price = calculatePrice();
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
        this.price = calculatePrice();
    }

    // Calculate price
    public double calculatePrice() {

        if (size == null) {
            return 0.0;
        }

        switch (size.toLowerCase()) {

            case "small":
                return 2.00;

            case "medium":
                return 2.50;

            case "large":
                return 3.00;

            default:
                return 0.0;
        }
    }

    // Display drink
    public void displayDrink() {

        System.out.println(
                size + " " +
                        flavor +
                        " Drink - $" +
                        String.format("%.2f", price)
        );
    }

    // Convert object to string
    @Override
    public String toString() {

        return size + " "
                + flavor
                + " Drink - $"
                + String.format("%.2f", price);
    }
}