public abstract class BasePayment {

    private String transactionID;
    private double feePercentage;

    public BasePayment(String transactionID, double feePercentage) {
        this.transactionID = transactionID;
        this.feePercentage = feePercentage;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public double getFeePercentage() {
        return feePercentage;
    }

    public void setFeePercentage(double feePercentage) {
        this.feePercentage = feePercentage;
    }

    public abstract boolean authenticate();

    public abstract void printReceipt();

    public double calculateTotal(double amount) {
        return amount + getFee(amount);
    }

    public double getFee(double amount) {
        return amount * feePercentage / 100;
    }
}
