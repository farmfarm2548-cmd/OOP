public abstract class DeliveryOrder implements iDelivery {

    private double foodPrice;

    public DeliveryOrder(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public abstract double calculateTotal();

    public void printReceipt() {
        System.out.println("--- Receipt ---");
        System.out.println("Food Price: " + foodPrice + " baht");
        System.out.println("Total Price (inc. Delivery): " + calculateTotal() + " baht");
        System.out.println("----------------");
        System.out.println();
    }
}
