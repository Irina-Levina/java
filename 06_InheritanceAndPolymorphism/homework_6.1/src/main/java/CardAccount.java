public class CardAccount extends BankAccount {

    protected CardAccount() {
    }

   protected CardAccount(double amount) {
        super(amount);
    }

    @Override
    protected boolean take(double amountToTake) {
        return super.take(amountToTake * 1.01);

    }

}

