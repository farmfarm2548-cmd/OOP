public class FoodDelivery {

    public static void main(String[] args) {
        DeliveryOrder order1 = new GrabOrder(200);
        order1.printReceipt();

        DeliveryOrder order2 = new LinemanOrder(300);
        order2.printReceipt();
    }
}
