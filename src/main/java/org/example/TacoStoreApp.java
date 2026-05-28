package org.example;
import java.util.Scanner;

public class TacoStoreApp {

    private Scanner scanner = new Scanner(System.in);
    private Orders order;

    // START APP
    public void start() {

        System.out.println("================================");
        System.out.println("     WELCOME TO TACO-LICIOUS    ");
        System.out.println("================================");

        boolean running = true;

        while (running) {

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

    // CREATE ORDER
    public void createOrder() {

        // order = new Orders();

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
                    checkout();
                    ordering = false;
                    break;

                case "0":
                    System.out.println("Order canceled.");
                    ordering = false;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // ADD TACO
    public void addTaco() {

        System.out.println("\nEnter size (Single Taco, 3-Taco Plate, Burrito): ");
        String size = scanner.nextLine();

        System.out.println("Enter tortilla type (corn, flour, hard shell, bowl): ");
        String tortilla = scanner.nextLine();

        Taco taco = new Taco(size, tortilla);

        boolean addingToppings = true;

        while (addingToppings) {

            System.out.println("\nEnter topping name (or type 'done'):");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("done")) {
                break;
            }

            System.out.println("Is it premium? (true/false): ");
            boolean premium = Boolean.parseBoolean(scanner.nextLine());

            System.out.println("Is it extra? (true/false): ");
            boolean extra = Boolean.parseBoolean(scanner.nextLine());

            taco.addTopping(new Topping(name, premium, extra));
        }

        System.out.println("Add queso? (true/false): ");
        taco.setHasQueso(Boolean.parseBoolean(scanner.nextLine()));

        System.out.println("Add salsa? (true/false): ");
        taco.setHasSalsa(Boolean.parseBoolean(scanner.nextLine()));

        // order.addTaco(taco);

        System.out.println("Taco added!");
    }

    // ADD DRINK
    public void addDrink() {

        System.out.println("\nEnter size (small, medium, large): ");
        String size = scanner.nextLine();

        System.out.println("Enter flavor: ");
        String flavor = scanner.nextLine();

        Drinks drink = new Drinks(size, flavor);

        //   order.addDrink(drink);

        System.out.println("Drink added!");
    }

    // ADD CHIPS
    public void addChips() {

        System.out.println("\nEnter salsa type (mild, medium, hot): ");
        String salsa = scanner.nextLine();

        ChipsAndSalsa chips = new ChipsAndSalsa(salsa);

        //   order.addChips(chips);

        System.out.println("Chips added!");
    }

    // CHECKOUT
    public void checkout() {

        System.out.println("\n===== CHECKOUT =====");

        //  order.calculateTotal();
        //   order.displayOrder();

        // if (order.getTacos().isEmpty()
        //      && order.getDrinks().isEmpty()
        //      && order.getChips().isEmpty()) {

        System.out.println("You must order at least a drink or chips & salsa!");
        return;
    }

    //   System.out.println("\nConfirm order? (yes/no): ");

    String confirm = scanner.nextLine();
}

     //   if (confirm.equalsIgnoreCase("yes")) {

        //    ReceiptFileManager.saveReceipt(order);
        //    System.out.println("Order completed! Receipt saved.");
     //   } else {
      //      System.out.println("Order canceled.");
