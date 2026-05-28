package org.example;
import java.util.ArrayList;
import java.util.List;

public class Orders {

    private List<Taco> tacos;
    private List<Drinks> drinks;
    private List<ChipsAndSalsa> chips;
    private double totalPrice;

    public Orders() {

        tacos = new ArrayList<>();
        drinks = new ArrayList<>();
        chips = new ArrayList<>();
        totalPrice = 0.0;
    }

    public void addTaco(Taco taco) {
        tacos.add(0, taco);
        calculateTotal();
    }

    public void addDrink(Drinks drink) {
        drinks.add(0, drink);
        calculateTotal();
    }

    public void addChips(ChipsAndSalsa chip) {
        chips.add(0, chip);
        calculateTotal();
    }

    public List<Taco> getTacos() {
        return tacos;
    }

    public List<Drinks> getDrinks() {
        return drinks;
    }

    public List<ChipsAndSalsa> getChips() {
        return chips;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double calculateTotal() {

        double total = 0.0;

        for (Taco taco : tacos) {
            total += taco.getPrice();
        }

        for (Drinks drink : drinks) {
            total += drink.getPrice();
        }

        for (ChipsAndSalsa chip : chips) {
            total += chip.getPrice();
        }

        totalPrice = total;
        return totalPrice;
    }

    public void displayOrder() {

        System.out.println("\n===== ORDER SUMMARY =====");

        System.out.println("\nTACOS:");
        if (tacos.isEmpty()) {
            System.out.println("None");
        } else {
            for (Taco taco : tacos) {
                taco.displayTaco();
            }
        }

        System.out.println("\nDRINKS:");
        if (drinks.isEmpty()) {
            System.out.println("None");
        } else {
            for (Drinks drink : drinks) {
                drink.displayDrink();
            }
        }

        System.out.println("\nCHIPS & SALSA:");
        if (chips.isEmpty()) {
            System.out.println("None");
        } else {
            for (ChipsAndSalsa chip : chips) {
                chip.display();
            }
        }

        System.out.println("\nTOTAL: $" + String.format("%.2f", totalPrice));
    }
}
