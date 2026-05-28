package org.example;
import java.util.ArrayList;
import java.util.List;

    public class Orders {

    // Fields
    private List<Taco> tacos;
    private List<Drinks> drinks;
    private List<ChipsAndSalsa> chips;

    private double totalPrice;

    // Constructor
    public Orders() {

        tacos = new ArrayList<>();
        drinks = new ArrayList<>();
        chips = new ArrayList<>();

        totalPrice = 0.0;
    }

    // Add taco
    public void addTaco(Taco taco) {
        tacos.add(taco);
        calculateTotal();
    }

    // Add drink
    public void addDrink(Drinks drink) {
        drinks.add(drink);
        calculateTotal();
    }

    // Add chips
    public void addChips(ChipsAndSalsa chip) {
        chips.add(chip);
        calculateTotal();
    }

    // Get tacos
    public List<Taco> getTacos() {
        return tacos;
    }

    // Get drinks
    public List<Drinks> getDrinks() {
        return drinks;
    }

    // Get chips
    public List<ChipsAndSalsa> getChips() {
        return chips;
    }

    // Get total price
    public double getTotalPrice() {
        return totalPrice;
    }

    // Calculate total price
    public double calculateTotal() {

        double total = 0.0;

        // Taco prices
        for (Taco taco : tacos) {
            total += taco.getPrice();
        }

        // Drink prices
        for (Drinks drink : drinks) {
            total += drink.getPrice();
        }

        // Chips prices
        for (ChipsAndSalsa chip : chips) {
            total += chip.getPrice();
        }

        totalPrice = total;

        return totalPrice;
    }

    // Display order summary
    public void displayOrder() {

        System.out.println("\n===== ORDER SUMMARY =====");

        // TACOS
        System.out.println("\nTACOS:");

        if (tacos.isEmpty()) {
            System.out.println("None");
        } else {

            for (Taco taco : tacos) {
                taco.displayTaco();
            }
        }

        // DRINKS
        System.out.println("\nDRINKS:");

        if (drinks.isEmpty()) {
            System.out.println("None");
        } else {

            for (Drinks drink : drinks) {
                drink.displayDrink();
            }
        }

        // CHIPS
        System.out.println("\nCHIPS & SALSA:");

        if (chips.isEmpty()) {
            System.out.println("None");
        } else {

            for (ChipsAndSalsa chip : chips) {
                chip.display();
            }
        }

        // TOTAL
        System.out.println("\nTOTAL: $" +
                String.format("%.2f", totalPrice));
    }
}