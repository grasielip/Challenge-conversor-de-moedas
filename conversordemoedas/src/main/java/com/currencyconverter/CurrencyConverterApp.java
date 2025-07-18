package com.currencyconverter;

import java.util.Scanner;

public class CurrencyConverterApp {
    private static final CurrencyService currencyService = new CurrencyService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    convertBRLToUSD();
                    break;
                case "2":
                    convertUSDtoBRL();
                    break;
                case "3":
                    convertBRLToEUR();
                    break;
                case "4":
                    convertEURtoBRL();
                    break;
                case "5":
                    convertBRLToJPY();
                    break;
                case "6":
                    convertJPYtoBRL();
                    break;
                case "0":
                    System.out.println("Encerrando o programa...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n=== Conversor de Moedas ===");
        System.out.println("1. Converter BRL para USD");
        System.out.println("2. Converter USD para BRL");
        System.out.println("3. Converter BRL para EUR");
        System.out.println("4. Converter EUR para BRL");
        System.out.println("5. Converter BRL para JPY");
        System.out.println("6. Converter JPY para BRL");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void convertBRLToUSD() {
        try {
            System.out.print("\nDigite o valor em BRL: ");
            double amount = getValidAmount();
            double result = currencyService.convert(amount, "BRL", "USD");
            System.out.printf("%.2f BRL = %.2f USD\n", amount, result);
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    private static void convertUSDtoBRL() {
        try {
            System.out.print("\nDigite o valor em USD: ");
            double amount = getValidAmount();
            double result = currencyService.convert(amount, "USD", "BRL");
            System.out.printf("%.2f USD = %.2f BRL\n", amount, result);
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    private static void convertBRLToEUR() {
        try {
            System.out.print("\nDigite o valor em BRL: ");
            double amount = getValidAmount();
            double result = currencyService.convert(amount, "BRL", "EUR");
            System.out.printf("%.2f BRL = %.2f EUR\n", amount, result);
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    private static void convertEURtoBRL() {
        try {
            System.out.print("\nDigite o valor em EUR: ");
            double amount = getValidAmount();
            double result = currencyService.convert(amount, "EUR", "BRL");
            System.out.printf("%.2f EUR = %.2f BRL\n", amount, result);
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    private static void convertBRLToJPY() {
        try {
            System.out.print("\nDigite o valor em BRL: ");
            double amount = getValidAmount();
            double result = currencyService.convert(amount, "BRL", "JPY");
            System.out.printf("%.2f BRL = %.2f JPY\n", amount, result);
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

    private static void convertJPYtoBRL() {
        try {
            System.out.print("\nDigite o valor em JPY: ");
            double amount = getValidAmount();
            double result = currencyService.convert(amount, "JPY", "BRL");
            System.out.printf("%.2f JPY = %.2f BRL\n", amount, result);
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
    
    private static double getValidAmount() {
        while (true) {
            try {
                double amount = Double.parseDouble(scanner.nextLine().replace(",", "."));
                if (amount <= 0) {
                    System.out.print("Por favor, digite um valor maior que zero: ");
                    continue;
                }
                return amount;
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido. Por favor, digite um número válido: ");
            }
        }
    }
}
