package org.example;
import java.util.ArrayList;
import java.util.List;

public class Taco {

    private String size;
    private String tortillaType;
    private List<Topping> toppings;
    private boolean hasQueso;
    private boolean hasSalsa;
    private double price;

    public Taco(String size, String tortillaType) {

        this.size = size;
        this.tortillaType = tortillaType;
        this.toppings = new ArrayList<>();
        this.hasQueso = false;
        this.hasSalsa = false;
        this.price = calculatePrice();
    }

    public String getSize() {
        return size;
    }

    public String getTortillaType() {
        return tortillaType;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public double getPrice() {
        return price;
    }

    public boolean isHasQueso() {
        return hasQueso;
    }

    public boolean isHasSalsa() {
        return hasSalsa;
    }

    public void setHasQueso(boolean hasQueso) {
        this.hasQueso = hasQueso;
    }

    public void setHasSalsa(boolean hasSalsa) {
        this.hasSalsa = hasSalsa;
    }

    public void addTopping(Topping topping) {

        toppings.add(topping);
        price = calculatePrice();
    }

    public double calculatePrice() {

        double basePrice;

        switch (size.toLowerCase()) {

            case "single taco":
                basePrice = 3.50;
                break;

            case "3-taco plate":
                basePrice = 9.00;
                break;

            case "burrito":
                basePrice = 8.50;
                break;

            default:
                basePrice = 0.0;
        }

        for (Topping topping : toppings) {
            basePrice += topping.getPrice();
        }

        return basePrice;
    }

    public void displayTaco() {

        System.out.println("\n--- Taco/Burrito ---");
        System.out.println("Size: " + size);
        System.out.println("Shell: " + tortillaType);

        System.out.println("Toppings:");

        if (toppings.isEmpty()) {
            System.out.println("None");
        } else {
            for (Topping topping : toppings) {
                System.out.println("- " + topping);
            }
        }

        System.out.println("Covered in salsa: " + hasSalsa);
        System.out.println("Covered in queso: " + hasQueso);
        System.out.println("Price: $" + String.format("%.2f", price));
    }

    @Override
    public String toString() {
        return size + " (" + tortillaType + ") - $" + String.format("%.2f", price);
    }
}
