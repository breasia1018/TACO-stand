import java.util.ArrayList;
import java.util.List;

public class Taco {

    // Fields
    private String size;
    private String tortillaType;
    private List<Topping> toppings;
    private boolean hasQueso;
    private boolean hasSalsa;
    private double price;

    // Constructor
    public Taco(String size, String tortillaType) {
        this.size = size;
        this.tortillaType = tortillaType;
        this.toppings = new ArrayList<>();
        this.hasQueso = false;
        this.hasSalsa = false;
        this.price = calculatePrice();
    }

    // Getters
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

    // Setters
    public void setSize(String size) {
        this.size = size;
        this.price = calculatePrice();
    }

    public void setTortillaType(String tortillaType) {
        this.tortillaType = tortillaType;
    }

    public void setHasQueso(boolean hasQueso) {
        this.hasQueso = hasQueso;
        this.price = calculatePrice();
    }

    public void setHasSalsa(boolean hasSalsa) {
        this.hasSalsa = hasSalsa;
        this.price = calculatePrice();
    }

    // Add topping
    public void addTopping(Topping topping) {
        toppings.add(topping);
        this.price = calculatePrice();
    }

    // Calculate price
    public double calculatePrice() {

        double basePrice = 0.0;

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

        for (Topping t : toppings) {
            basePrice += t.getPrice();
        }

        if (hasQueso) {
            basePrice += 0.75;
        }

        if (hasSalsa) {
            basePrice += 0.50;
        }

        return basePrice;
    }

    // Display taco
    public void displayTaco() {

        System.out.println("\n--- Taco ---");
        System.out.println("Size: " + size);
        System.out.println("Tortilla: " + tortillaType);

        System.out.println("Toppings:");
        for (Topping t : toppings) {
            System.out.println("- " + t.getName());
        }

        System.out.println("Queso: " + hasQueso);
        System.out.println("Salsa: " + hasSalsa);
        System.out.println("Price: $" + price);
    }
}