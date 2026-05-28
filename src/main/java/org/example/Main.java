package org.example;

public class Main {

    public static final String RESET = "\u001B[0m";
    public static final String YELLOW = "\u001B[33;1m";

    public static void main(String[] args) {

        printBanner();

        TacoStoreApp app = new TacoStoreApp();
        app.start();
    }

    public static void printBanner() {

        System.out.println(YELLOW + "========================================" + RESET);
        System.out.println();

        System.out.println(YELLOW + "███████╗ ████╗  █████╗ █████╗" + RESET);
        System.out.println(YELLOW + "╚══█══╝██╔══██╗██╔════╝██╔═══██╗" + RESET);
        System.out.println(YELLOW + "   █║   █████║██║     ██║   ██║" + RESET);
        System.out.println(YELLOW + "   █║   ██╔══█║██║     ██║   ██║" + RESET);
        System.out.println(YELLOW + "   █║   ██║  █║╚██████╗╚██████╔╝" + RESET);
        System.out.println(YELLOW + "   ╚═╝   ╚═╝  ╚═╝ ╚═════╝ ╚═════╝" + RESET);

        System.out.println();
        System.out.println(YELLOW + "        🌮 T A C O   S T O R E 🌮" + RESET);
        System.out.println(YELLOW + "     Fresh • Fast • Flavorful" + RESET);

        System.out.println();
        System.out.println(YELLOW + "========================================" + RESET);
    }
}