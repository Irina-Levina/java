import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {


        Bank bank = new Bank();
        Long sumAllAccountBeforeTransfer = bank.getSumAllAccounts();

        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor)Executors.newFixedThreadPool(20);

        for(int i = 0; i < 500; i++){

            threadPoolExecutor.execute( ()->
            {
                int from = (int) (1 + 500 * Math.random());
                int to = 501 - from;

                String fromAccountNum = Integer.toString(from);
                String toAccountNum = Integer.toString(to);

                long amount = Math.round(52500 * Math.random());
                System.out.println("Сумма перевода "  + amount);

                try {
                    bank.transfer(fromAccountNum, toAccountNum, amount);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } );
        }
        threadPoolExecutor.shutdown();

        try {
            threadPoolExecutor.awaitTermination(30,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Long sumAllAccountAfterTransfer = bank.getSumAllAccounts();

        if(sumAllAccountAfterTransfer-sumAllAccountBeforeTransfer!=0){
            System.out.println( "Что-то пошло не так !(");
        }else {
            System.out.println( "Все транзакции выполнены успешно");
        }


    }


}
