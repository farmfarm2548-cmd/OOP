public class CryptoPayment extends BasePayment implements iPayment {

    private double amount;

    public CryptoPayment(String transactionID) {
        super(transactionID, 0.1);
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
        System.out.println("[Crypto] Transaction ID: " + getTransactionID());
        System.out.println("[Crypto] Verifying Wallet Private Key & Blockchain Network...");
        return true;
    }

    @Override
    public void processPayment(double amount) {
        if (authenticate()) {
            this.amount = amount;
            System.out.println("[Crypto] Transferring "
                    + String.format("%,.1f", calculateTotal(this.amount))
                    + " USDT (Gas Fee: " + getFeePercentage() + "%)");
            System.out.println();
        }
    }

    @Override
    public void printReceipt() {
        System.out.println("--------- Receipt of Crypto --------");
        System.out.println(String.format("%-16s%20s", "Transfer:", String.format("%,.1f", amount) + " USDT"));
        System.out.println(String.format("%-16s%20s", "Gas Fee (" + getFeePercentage() + "%):",
                String.format("%,.1f", getFee(amount)) + " USDT"));
        System.out.println(String.format("%-16s%20s", "Total:", String.format("%,.1f", calculateTotal(amount)) + " USDT"));
        System.out.println("------------------------------------");
    }
}
