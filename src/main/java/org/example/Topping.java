public class Topping {
    // Fields
    private String name;
    private boolean premium;
    private boolean extra;
    private double price;

    // Constructor
    public Topping(String name, boolean premium, boolean extra) {

        this.name = name;
        this.premium = premium;
        this.extra = extra;
        this.price = calculatePrice();
    }

    // Getters
    public String getName() {
        return name;
    }

    public boolean isPremium() {
        return premium;
    }

    public boolean isExtra() {
        return extra;
    }

    public double getPrice() {
        return price;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
        this.price = calculatePrice();
    }

    public void setExtra(boolean extra) {
        this.extra = extra;
        this.price = calculatePrice();
    }

    // Calculate topping price
    public double calculatePrice() {

        double toppingPrice = 0.0;

        // Premium toppings cost extra
        if (premium) {
            toppingPrice += 1.00;
        }

        // Extra toppings cost more
        if (extra) {

            if (premium) {
                toppingPrice += 1.50;
            } else {
                toppingPrice += 0.50;
            }
        }

        return toppingPrice;
    }

    // Display topping info
    public void displayTopping() {

        System.out.println(name +
                " | Premium: " + premium +
                " | Extra: " + extra +
                " | Price: $" + price);
    }
}

