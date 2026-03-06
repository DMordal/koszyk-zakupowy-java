package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("products.txt");
        Scanner fileScanner = new Scanner(file);

        ArrayList<String> productNames = new ArrayList<>();
        ArrayList<Double> productPrices = new ArrayList<>();

        while (fileScanner.hasNextLine()) {

            String line = fileScanner.nextLine();

            String[] parts = line.split(";");

            String productName = parts[0];
            double productPrice = Double.parseDouble(parts[1]);

            System.out.println(productName + " - " + productPrice);
            productNames.add(productName);
            productPrices.add(productPrice);
        }

        fileScanner.close();
        double total = 0;
        double smallDiscount = 0.10;
        double bigDiscount = 0.25;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select product:");

        for (int i = 0; i < productNames.size(); i++) {

            System.out.println((i + 1) + ". "
                    + productNames.get(i)
                    + " - "
                    + productPrices.get(i));
        }

        System.out.println("0. finish");
        while (!scanner.hasNextDouble()) {
            System.out.println("It's not a number! Try again:");
            scanner.next();
        }

        int choice = scanner.nextInt();
        double price = productPrices.get(choice - 1);
        total += price;

        scanner.nextLine();

        double toSmallDiscount = 100 - total;
        double toBigDiscount = 400 - total;

        System.out.printf("Current cart total: %.2f PLN%n", total);

        if (total < 100) {
            System.out.printf("You need %.2f PLN more to get a 10%% discount%n", toSmallDiscount);
        } else if (total < 400) {
            System.out.printf("You have a 10%% discount. %.2f PLN left to reach a 25%% discount%n", toBigDiscount);
        } else {
            System.out.println("You have a 25% discount");
        }

        double totalWithDiscount = total;

        if (total >= 400) {
            totalWithDiscount = total * (1 - bigDiscount);
        } else if (total >= 100) {
            totalWithDiscount = total * (1 - smallDiscount);
        }

        System.out.printf("Final total after discount: %.2f PLN%n", totalWithDiscount);

        scanner.close();
    }}
