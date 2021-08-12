public class LegalPerson extends Client {

    public LegalPerson(){
        System.out.println("LegalPerson счет. Доступный баланс - " + getAmount());
        System.out.println("При снятии взимается комиссия 1%");

    }

    @Override
    public void take(double amountToTake) {
        super.take(amountToTake*1.01);
    }
}

