package org.example;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptFileManager {

    public static void saveReceipt(Orders finalOrder) {

        File folder = new File("receipts");

        if (!folder.exists()) {
            folder.mkdir();
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String fileName = "receipts/" + LocalDateTime.now().format(formatter) + ".txt";

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

            writer.write("===== TACO-LICIOUS RECEIPT =====\n\n");

            writer.write("TACOS:\n");
            if (finalOrder.getTacos().isEmpty()) {
                writer.write("None\n");
            } else {
                for (Taco taco : finalOrder.getTacos()) {
                    writer.write("- " + taco.getSize() + " (" + taco.getTortillaType() + ") - $"
                            + String.format("%.2f", taco.getPrice()) + "\n");

                    writer.write("  Toppings:\n");
                    if (taco.getToppings().isEmpty()) {
                        writer.write("   * None\n");
                    } else {
                        for (Topping topping : taco.getToppings()) {
                            writer.write("   * " + topping + "\n");
                        }
                    }

                    writer.write("   * Covered in salsa: " + taco.isHasSalsa() + "\n");
                    writer.write("   * Covered in queso: " + taco.isHasQueso() + "\n");
                }
            }

            writer.write("\nDRINKS:\n");
            if (finalOrder.getDrinks().isEmpty()) {
                writer.write("None\n");
            } else {
                for (Drinks drink : finalOrder.getDrinks()) {
                    writer.write("- " + drink + "\n");
                }
            }

            writer.write("\nCHIPS & SALSA:\n");
            if (finalOrder.getChips().isEmpty()) {
                writer.write("None\n");
            } else {
                for (ChipsAndSalsa chips : finalOrder.getChips()) {
                    writer.write("- " + chips + "\n");
                }
            }

            writer.write("\nTOTAL: $" + String.format("%.2f", finalOrder.getTotalPrice()));

            writer.close();

            System.out.println("Receipt saved successfully: " + fileName);

        } catch (IOException e) {
            System.out.println("Error saving receipt.");
        }
    }
}
