import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Currency Converter");
        System.out.println("Available Currencies:");
        System.out.println("1. USD");
        System.out.println("2. INR");
        System.out.println("3. EUR");
        System.out.println("4. GBP");
        System.out.println("5. RUB");

        System.out.print("Enter base currency (USD/INR/EUR/GBP/RUB): ");
        String baseCurrency = scanner.next().toUpperCase();

        System.out.print("Enter target currency (USD/INR/EUR/GBP/RUB): ");
        String targetCurrency = scanner.next().toUpperCase();

        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();

        double rate = getExchangeRate(baseCurrency, targetCurrency);
        if (rate == -1) {
            System.out.println("Invalid currency selection or rate not available.");
        } else {
            double convertedAmount = amount * rate;
            System.out.printf("Converted Amount: %.2f %s\n", convertedAmount, targetCurrency);
        }

        scanner.close();
    }

    static double getExchangeRate(String from, String to) {
        if (from.equals(to)) return 1.0;

        switch (from + "_" + to) {
            case "USD_INR": return 83.10;
            case "INR_USD": return 0.012;
            case "USD_EUR": return 0.91;
            case "EUR_USD": return 1.10;
            case "USD_GBP": return 0.78;
            case "GBP_USD": return 1.28;
            case "USD_RUB": return 144.5;
            case "RUB_USD": return 0.0069;
            case "EUR_INR": return 90.35;
            case "INR_EUR": return 0.011;
            case "GBP_INR": return 105.20;
            case "INR_GBP": return 0.0095;
            case "RUB_INR": return 0.57;
            case "INR_RUB": return 1.74;
            default: return -1;
        }
    }
}
