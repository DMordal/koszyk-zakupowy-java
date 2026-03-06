package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double total = 0;
        double smallDiscount = 0.10;
        double bigDiscount = 0.25;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter product name (or 'end'):");

        String product = scanner.nextLine();

        while (!product.equals("end")) {

            while (!product.matches("[a-zA-Z ]+")) {
                System.out.println("Invalid product name! Try again:");
                product = scanner.nextLine();
            }

            System.out.println("Enter product price:");

            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid price! Try again:");
                scanner.next();
            }

            double price = scanner.nextDouble();
            total += price;

            scanner.nextLine();

            double toSmallDiscount = 100 - total;
            double toBigDiscount = 400 - total;

            System.out.printf("Current cart total: %.2f PLN%n", total);

            if (total < 100) {
                System.out.printf("You need %.2f PLN more to get a 10%% discount%n", toSmallDiscount);
            }
            else if (total < 400) {
                System.out.printf("You have a 10%% discount. %.2f PLN left to reach a 25%% discount%n", toBigDiscount);
            }
            else {
                System.out.println("You have a 25% discount");
            }

            System.out.println("Enter next product (or 'end'):");
            product = scanner.nextLine();
        }

        double totalWithDiscount = total;

        if (total >= 400) {
            totalWithDiscount = total * (1 - bigDiscount);
        }
        else if (total >= 100) {
            totalWithDiscount = total * (1 - smallDiscount);
        }

        System.out.printf("Final total after discount: %.2f PLN%n", totalWithDiscount);

        scanner.close();
    }
}