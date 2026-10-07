public class CreditCardPayment extends BasePayment implements iPayment {

    private double amount;

    public CreditCardPayment(String transactionID) {
        super(transactionID, 1.5);
        this.amount = 0;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean authenticate() {
        System.out.println("[CreditCard] Transaction ID: " + getTransactionID());
        System.out.println("[CreditCard] Verifying CVV and Credit Limit...");
        return true;
    }

    @Override
    public void processPayment(double amount) {
        if (authenticate()) {
            this.amount = amount;
            System.out.println("[CreditCard] Charging "
                    + String.format("%,.1f", calculateTotal(this.amount))
                    + "$ (Fee: " + getFeePercentage() + "%)");
            System.out.println();
        }
    }

    @Override
    public void printReceipt() {
        System.out.println("----- Receipt of CreditCard ----");
        System.out.println(String.format("%-12s%20s", "Amount:", String.format("%,.1f", amount) + "$"));
        System.out.println(String.format("%-12s%20s", "Fee (" + getFeePercentage() + "%):",
                String.format("%,.1f", getFee(amount)) + "$"));
        System.out.println(String.format("%-12s%20s", "Total:", String.format("%,.1f", calculateTotal(amount)) + "$"));
        System.out.println("--------------------------------");
    }
}
