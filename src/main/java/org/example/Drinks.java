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

    public void setSize(String size) {
        this.size = size;
        this.price = calculatePrice();
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
        this.price = calculatePrice();
    }

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

    // (Kept for printing directly to the console)
    public void displayDrink() {
        System.out.println(size + " " + flavor + " Drink - $" + String.format("%.2f", price));
    }

    // =====================================================================
    // NEW FILE MANAGER INTEGRATION
    // =====================================================================

    // TODO 1: We need a way to pass this drink's details as text to the Order class!
    // The standard Java way to do this is by overriding the built-in toString() method.
    // Add this line right below this comment: @Override

    // TODO 2: Create a method with this exact signature: public String toString()

    // TODO 3: Inside your new toString() method, RETURN the exact same formatted text
    // you used in displayDrink(), but WITHOUT wrapping it in a System.out.println().
}