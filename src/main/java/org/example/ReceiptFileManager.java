import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReceiptFileManager {

    // Save receipt to file
    public static void saveReceipt(Orders finalOrder) {

        // Create receipts folder
        File folder = new File("receipts");

        if (!folder.exists()) {
            folder.mkdir();
        }

        // Create file name
        String fileName = "receipts/Receipt_" +
                System.currentTimeMillis() + ".txt";

        try {

            BufferedWriter writer =
                    new BufferedWriter(new FileWriter(fileName));

            writer.write("===== TACO-LICIOUS RECEIPT =====\n\n");

            // TACOS
            writer.write("TACOS:\n");

            for (Taco taco : finalOrder.getTacos()) {

                writer.write("- " + taco.getSize()
                        + " (" + taco.getTortillaType() + ")\n");

                for (Topping topping : taco.getToppings()) {
                    writer.write("   * " + topping.getName() + "\n");
                }
            }

            // DRINKS
            writer.write("\nDRINKS:\n");

            for (Drinks drink : finalOrder.getDrinks()) {

                writer.write("- " + drink.getSize()
                        + " "
                        + drink.getFlavor()
                        + " ($"
                        + drink.getPrice()
                        + ")\n");
            }

            // CHIPS
            writer.write("\nCHIPS & SALSA:\n");

            for (ChipsAndSalsa chips : finalOrder.getChips()) {

                writer.write("- "
                        + chips.getSalsaType()
                        + " ($"
                        + chips.getPrice()
                        + ")\n");
            }

            // TOTAL
            writer.write("\nTOTAL: $"
                    + String.format("%.2f",
                    finalOrder.getTotalPrice()));

            writer.close();

            System.out.println("Receipt saved successfully!");

        } catch (IOException e) {

            System.out.println("Error saving receipt.");
        }
    }
}


