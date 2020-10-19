package be.howest.ti.jdbc.ui.cli;

import be.howest.ti.jdbc.data.ProductRepository;
import be.howest.ti.jdbc.data.Repositories;
import be.howest.ti.jdbc.domain.Product;
import be.howest.ti.jdbc.util.ShopException;

import java.util.Scanner;

@SuppressWarnings("squid:S106")
public class CommandLineApp {

    public static void main(String[] args) {
        new CommandLineApp().run();
    }


    private final Scanner in = new Scanner(System.in);
    private final ProductRepository repo = Repositories.getProductsRepo();

    private void run() {

        boolean cont = true;
        while (cont) {
            cont = showMenu();
        }

    }

    private boolean showMenu() {

        int tries = 0;

        while (tries < 5) {
            System.out.println("1. Show products");
            System.out.println("2. Add product");
            System.out.println("3. STOP");
            String input = in.nextLine();

            try {
                int i = Integer.parseInt(input);
                System.out.println("You selected:" + i);
                switch (i) {
                    case 1: showProducts(); return true;
                    case 2: addProduct(); return true;
                    case 3: return false;
                    default: System.out.println("That is not a valid option.");
                }
            } catch (NumberFormatException ex) {
                System.out.println("That is not a valid option, need a number.");
            }
            tries++;
        }
        return false;

    }

    private void addProduct() {
        System.out.println("Add a new product:");
        String name = readProductName();
        double price = readPrice();
        int vat = readVAT();

        repo.addProduct(new Product(name, price, vat));
    }

    private double readPrice() {
        int tries = 0;
        while (tries < 3) {
            System.out.println("What is the price: ");
            try {
                return Double.parseDouble(in.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("(the price is a number)");
            }

            tries++;
        }
        throw new ShopException("Unable to read VAT");
    }

    private String readProductName() {
        System.out.println("Product name: ");
        return in.nextLine();
    }

    private int readVAT() {
        int tries = 0;
        while (tries < 3) {
            System.out.println("What is the VAT (6, 12, 21)?: ");
            try {
                int vat = Integer.parseInt(in.nextLine());

                if (vat==6 || vat==12 || vat==21){
                    return vat;
                }

            } catch (NumberFormatException ex) {
                System.out.println("(the vat is a number)");
            }

            tries++;
        }
        throw new ShopException("Unable to read VAT");
    }

    private void showProducts() {
        System.out.println("Products:\n==========");
        for(Product p : repo.getProducts()) {
            System.out.println(p);
        }
        System.out.println("==========\n");
    }

}
