package org.example;
public class Topping {

    private String name;
    private String category;
    private boolean extra;
    private String tacoSize;
    private double price;

    public Topping(String name, String category, boolean extra, String tacoSize) {

        this.name = name;
        this.category = category;
        this.extra = extra;
        this.tacoSize = tacoSize;
        this.price = calculatePrice();
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public boolean isExtra() {
        return extra;
    }

    public double getPrice() {
        return price;
    }

    public double calculatePrice() {

        double toppingPrice = 0.0;

        if (category.equalsIgnoreCase("meat")) {

            switch (tacoSize.toLowerCase()) {

                case "single taco":
                    toppingPrice = 1.00;
                    if (extra) {
                        toppingPrice += 0.50;
                    }
                    break;

                case "3-taco plate":
                    toppingPrice = 2.00;
                    if (extra) {
                        toppingPrice += 1.00;
                    }
                    break;

                case "burrito":
                    toppingPrice = 3.00;
                    if (extra) {
                        toppingPrice += 1.50;
                    }
                    break;
            }
        } else if (category.equalsIgnoreCase("cheese")) {

            switch (tacoSize.toLowerCase()) {

                case "single taco":
                    toppingPrice = 0.75;
                    if (extra) {
                        toppingPrice += 0.30;
                    }
                    break;

                case "3-taco plate":
                    toppingPrice = 1.50;
                    if (extra) {
                        toppingPrice += 0.60;
                    }
                    break;

                case "burrito":
                    toppingPrice = 2.25;
                    if (extra) {
                        toppingPrice += 0.90;
                    }
                    break;
            }
        }

        return toppingPrice;
    }

    @Override
    public String toString() {

        String extraText = "";

        if (extra) {
            extraText = " extra";
        }

        return name + " (" + category + extraText + ") - $" + String.format("%.2f", price);
    }
}
