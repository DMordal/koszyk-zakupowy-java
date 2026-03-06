package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double suma = 0;
        double malyRabat = 0.10;
        double duzyRabat = 0.25;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Wpisz produkt (lub 'koniec'):");

        String produkt = scanner.nextLine();

        while (!produkt.equals("koniec")) {

            while (!produkt.matches("[a-zA-ZąćęłńóśżźĄĆĘŁŃÓŚŻŹ ]+")) {
                System.out.println("To nie produkt! Spróbuj jeszcze raz:");
                produkt = scanner.nextLine();
            }

            System.out.println("Wpisz cenę:");

            while (!scanner.hasNextDouble()) {
                System.out.println("To nie cena! Spróbuj jeszcze raz:");
                scanner.next();
            }

            double cena = scanner.nextDouble();
            suma += cena;

            scanner.nextLine();

            double doMalegoRabatu = 100 - suma;
            double doDuzegoRabatu = 400 - suma;

            System.out.printf("Suma zakupów: %.2f zł%n", suma);

            if (suma < 100) {
                System.out.printf("Do rabatu 10%% brakuje %.2f zł%n", doMalegoRabatu);
            }
            else if (suma < 400) {
                System.out.printf("Masz rabat 10%%. Do rabatu 25%% brakuje %.2f zł%n", doDuzegoRabatu);
            }
            else {
                System.out.println("Masz rabat 25%");
            }

            System.out.println("Wpisz kolejny produkt (lub 'koniec'):");
            produkt = scanner.nextLine();
        }

        double sumaZRabatem = suma;

        if (suma >= 400) {
            sumaZRabatem = suma * (1 - duzyRabat);
        }
        else if (suma >= 100) {
            sumaZRabatem = suma * (1 - malyRabat);
        }

        System.out.printf("Końcowa suma po rabacie: %.2f zł%n", sumaZRabatem);

        scanner.close();
    }
}