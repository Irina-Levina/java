import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Bank {

    private Map<String, Account> accounts = new HashMap<>();
    private final Random random = new Random();

    public Bank() {
        for (int i = 1; i < 501; i++) {
            Account account = new Account();
            account.setAccNumber(Integer.toString(i));
            account.setMoney(Math.round(Math.random() * 1000000));
            accounts.put(account.getAccNumber(), account);

        }
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }


    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        if (amount > 50000 && isFraud(fromAccountNum, toAccountNum, amount)) {
            System.out.println("Счет заблокирован! Операция отклонена");
            return;
        }


        Account fromAccount = accounts.get(fromAccountNum);
        Account toAccount = accounts.get(toAccountNum);

        synchronized (fromAccount) {
            fromAccount.setMoney(fromAccount.getMoney() - amount);
        }
        synchronized (toAccount) {
            toAccount.setMoney(toAccount.getMoney() + amount);
        }

    }


    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        return accounts.values().stream().mapToLong(Account::getMoney).sum();
    }

}
