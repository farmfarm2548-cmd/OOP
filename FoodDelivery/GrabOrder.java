public class GrabOrder extends DeliveryOrder {

    public GrabOrder(double foodPrice) {
        super(foodPrice);
    }

    @Override
    public double calculateTotal() {
        return getFoodPrice() + (getFoodPrice() * GRAB_FEE / 100) + GRAB_DELIVERY;
    }
}
