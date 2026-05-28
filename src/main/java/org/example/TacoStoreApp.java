package org.example;
import java.util.Scanner;

public class TacoStoreApp {

    private Scanner scanner = new Scanner(System.in);
    private Orders order;

    public void start() {

        boolean running = true;

        while (running) {

            System.out.println("================================");
            System.out.println("     WELCOME TO TACO-LICIOUS    ");
            System.out.println("================================");

            System.out.println("\nMAIN MENU");
            System.out.println("1. New Order");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    createOrder();
                    break;

                case "0":
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public void createOrder() {

        order = new Orders();

        boolean ordering = true;

        while (ordering) {

            System.out.println("\nORDER MENU");
            System.out.println("1. Add Taco");
            System.out.println("2. Add Drink");
            System.out.println("3. Add Chips & Salsa");
            System.out.println("4. Checkout");
            System.out.println("0. Cancel Order");
            System.out.print("Choose: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    addTaco();
                    break;

                case "2":
                    addDrink();
                    break;

                case "3":
                    addChips();
                    break;

                case "4":
                    ordering = checkout();
                    break;

                case "0":
                    order = null;
                    System.out.println("Order canceled.");
                    ordering = false;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public void addTaco() {

        System.out.println("\nSelect shell (corn, flour, hard shell, bowl): ");
        String tortilla = scanner.nextLine();

        System.out.println("Taco size (Single Taco, 3-Taco Plate, Burrito): ");
        String size = scanner.nextLine();

        Taco taco = new Taco(size, tortilla);

        addToppingSection(taco, "meat");
        addToppingSection(taco, "cheese");
        addToppingSection(taco, "regular");
        addToppingSection(taco, "sauce");
        addToppingSection(taco, "side");

        System.out.println("Would you like it covered in salsa? (yes/no): ");
        taco.setHasSalsa(scanner.nextLine().equalsIgnoreCase("yes"));

        System.out.println("Would you like it covered in queso? (yes/no): ");
        taco.setHasQueso(scanner.nextLine().equalsIgnoreCase("yes"));

        order.addTaco(taco);

        System.out.println("Taco added!");
    }

    private void addToppingSection(Taco taco, String category) {

        boolean adding = true;

        while (adding) {

            System.out.println("\nAdd " + category + " topping? Type name or 'done': ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("done")) {
                adding = false;
            } else {

                System.out.println("Extra " + name + "? (yes/no): ");
                boolean extra = scanner.nextLine().equalsIgnoreCase("yes");

                taco.addTopping(new Topping(name, category, extra, taco.getSize()));
            }
        }
    }

    public void addDrink() {

        System.out.println("\nEnter size (small, medium, large): ");
        String size = scanner.nextLine();

        System.out.println("Enter flavor: ");
        String flavor = scanner.nextLine();

        Drinks drink = new Drinks(size, flavor);

        order.addDrink(drink);

        System.out.println("Drink added!");
    }

    public void addChips() {

        System.out.println("\nEnter salsa type (mild, medium, hot): ");
        String salsa = scanner.nextLine();

        ChipsAndSalsa chips = new ChipsAndSalsa(salsa);

        order.addChips(chips);

        System.out.println("Chips added!");
    }

    public boolean checkout() {

        if (order.getTacos().isEmpty()
                && order.getDrinks().isEmpty()
                && order.getChips().isEmpty()) {

            System.out.println("You must order at least one taco, drink, or chips & salsa.");
            return true;
        }

        order.calculateTotal();
        order.displayOrder();

        System.out.println("\n1. Confirm");
        System.out.println("0. Cancel");
        System.out.print("Choose: ");

        String choice = scanner.nextLine();

        switch (choice) {

            case "1":
                ReceiptFileManager.saveReceipt(order);
                order = null;
                System.out.println("Order completed!");
                return false;

            case "0":
                order = null;
                System.out.println("Order canceled.");
                return false;

            default:
                System.out.println("Invalid option. Returning to order menu.");
                return true;
        }
    }
}
