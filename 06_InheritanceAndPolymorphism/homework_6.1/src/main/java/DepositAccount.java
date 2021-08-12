import java.time.LocalDate;

public class DepositAccount extends BankAccount {
    private LocalDate lastIncome;


    protected DepositAccount() {
        this.lastIncome = LocalDate.now();
    }

    protected DepositAccount(double amount) {
        super(amount);
        this.lastIncome = LocalDate.now();
    }

    @Override
    protected boolean put(double amountToPut) {
        this.lastIncome = LocalDate.now();
        return super.put(amountToPut);

    }

    @Override
    protected boolean take(double amountToTake) {
        boolean isTake = false;
        if (lastIncome.plusMonths(1).isBefore(LocalDate.now())) {
            if (amountToTake < this.getAmount()) {
                isTake = super.take(amountToTake);
            }
        }
        return isTake;
    }
}
