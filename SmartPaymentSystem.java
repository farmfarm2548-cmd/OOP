import java.util.Scanner;

public class SmartPaymentSystem {

    private static void displayMenu() {
        System.out.println();
        System.out.println("=========== Smart Payment System =========");
        System.out.println("1. Credit Card");
        System.out.println("2. Crypto");
        System.out.println("9. Exit");
        System.out.println("==================================");
    }

    private static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            displayMenu();
            System.out.print("Enter menu: ");
            String choose = in.nextLine().trim();
            if (isNumber(choose)) {
                int menu = Integer.parseInt(choose);
                if (menu == 9) {
                    break;
                } else if (menu == 1) {
                    CreditCardPayment paidCard = new CreditCardPayment("TXN-7788");
                    paidCard.processPayment(1000);
                    paidCard.printReceipt();
                } else if (menu == 2) {
                    CryptoPayment paidCrypto = new CryptoPayment("0xABC123");
                    paidCrypto.processPayment(1000.5);
                    paidCrypto.printReceipt();
                } else {
                    System.out.println("Wrong menu number.");
                }
            } else {
                System.out.println();
                System.out.println("Allow only number. Try again.");
            }
        }
        in.close();
    }
}
