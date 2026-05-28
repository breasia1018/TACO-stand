public class ChipsAndSalsa {

    // Fields
    private String salsaType; // mild, medium, hot
    private double price;

    // Constructor
    public ChipsAndSalsa(String salsaType) {
        this.salsaType = salsaType;
        this.price = calculatePrice();
    }

    // Getter
    public String getSalsaType() {
        return salsaType;
    }

    public double getPrice() {
        return price;
    }

    // Setter
    public void setSalsaType(String salsaType) {
        this.salsaType = salsaType;
        this.price = calculatePrice();
    }

    // Pricing logic
    public double calculatePrice() {
        // Flat price for chips + salsa
        double basePrice = 2.50;
        return basePrice;
    }

    // Display method (Kept for printing directly to the console)
    public void display() {
        System.out.println("Chips & Salsa (" + salsaType + ") - $" + String.format("%.2f", price));
    }
}

// =====================================================================
// NEW FILE MANAGER INTEGRATION
// =====================================================================

// TODO 1: Just like with the Drinks class, the FileManager needs text, not a console printout!
// Add the @Override tag right here.

// TODO 2: Create your toString() method: public String toString()

// TODO 3: Return the exact same formatted string you used in display() so the Or