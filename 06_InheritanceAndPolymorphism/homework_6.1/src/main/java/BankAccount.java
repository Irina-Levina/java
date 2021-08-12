class BankAccount {
    private double amount = 0;

    protected BankAccount() {
    }

    protected BankAccount(double amount) {
        this.amount = amount;
    }

    protected double getAmount() {
        return amount;
    }

    protected boolean put(double amountToPut) {
        boolean isPut = false;
        if (amountToPut > 0) {

            double beforePut = this.getAmount();
            this.amount += amountToPut;
            double afterPut = this.getAmount();

            if ((afterPut - beforePut) == amountToPut) {
                isPut = true;
            }
        }
        return isPut;
    }


    protected boolean take(double amountToTake) {
        boolean isTake = false;
        if (amountToTake < this.amount) {

            double beforeTake = this.getAmount();
            this.amount -= amountToTake;
            double afterTake = this.getAmount();

            if ((beforeTake - afterTake) == amountToTake) {
                isTake = true;
            }
        }
        return isTake;
    }

    protected boolean send(BankAccount receiver, double amount) {
        boolean isSend = false;

        double beforeTake = this.getAmount();
        if (this.take(amount)) {

            if (receiver.put(amount)) {
                isSend = true;
            } else {
                this.amount = beforeTake;
            }
        }
        return isSend;
    }
}




