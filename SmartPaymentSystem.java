import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author coc
 */
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
            Integer.valueOf(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        do {
            displayMenu();
            System.out.print("Enter menu: ");
            String choose = in.nextLine();
            if (isNumber(choose)) {
                switch (Integer.parseInt(choose)) {
                    case 9:
                        System.exit(0);
                        break;
                    case 1:
                        CreditCardPayment paidCard = new CreditCardPayment("TXN-7788");
                        paidCard.processPayment(1000);
                        paidCard.printReceipt();
                        break;
                    case 2:
                        CryptoPayment paidCrypto = new CryptoPayment("0xABC123");
                        paidCrypto.processPayment(1000.5);
                        paidCrypto.printReceipt();
                        break;
                    default:
                        System.out.println("Wrong menu number.");
                }
            } else {
                System.out.println();
                System.out.println("Allow only number. Try again.");
            }
        } while (true);
    }
}
