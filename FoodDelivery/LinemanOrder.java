public class LinemanOrder extends DeliveryOrder {

    public LinemanOrder(double foodPrice) {
        super(foodPrice);
    }

    @Override
    public double calculateTotal() {
        return getFoodPrice() + (getFoodPrice() * LINEMAN_FEE / 100) + LINEMAN_DELIVERY;
    }
}
