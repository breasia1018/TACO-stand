package org.example;
public class Drinks {

    private String size;
    private String flavor;
    private double price;

    public Drinks(String size, String flavor) {

        this.size = size;
        this.flavor = flavor;
        this.price = calculatePrice();
    }

    public String getSize() {
        return size;
    }

    public String getFlavor() {
        return flavor;
    }

    public double getPrice() {
        return price;
    }

    public double calculatePrice() {

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

    public void displayDrink() {

        System.out.println(size + " " + flavor + " Drink - $" + String.format("%.2f", price));
    }

    @Override
    public String toString() {

        return size + " " + flavor + " Drink - $" + String.format("%.2f", price);
    }
}
