
public class Main {

     public static void main(String[] args) {

        CardAccount cardAccount = new CardAccount(500.0);
        DepositAccount deposit = new DepositAccount(1000);

        BankAccount bankAccount = new BankAccount(1551.0);

        System.out.println(bankAccount.send(cardAccount, 100.0));
        System.out.println("Обычный счет: " + bankAccount.getAmount());
        System.out.println("Карточный счет " + cardAccount.getAmount());

        cardAccount.take(30);
        System.out.println(cardAccount.getAmount());

        System.out.println("deposit " + deposit.getAmount());
        System.out.println("перевод " + bankAccount.send(deposit, 444));
        System.out.println("bank " + bankAccount.getAmount());
        System.out.println("deposit " + deposit.getAmount());


    }
}
