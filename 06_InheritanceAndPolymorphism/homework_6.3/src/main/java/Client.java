public abstract class Client {
    private double amount = 0;

    public double getAmount() {

        return amount;
    }

    public void put(double amountToPut) {
        if (amountToPut > 0) {
            this.amount += amountToPut;
        }
    }

    public void take(double amountToTake) {
        if (amountToTake <= amount) {
            this.amount -= amountToTake;
        }
    }

}
