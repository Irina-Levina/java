import java.util.*;
import java.util.concurrent.ForkJoinPool;


public class Main {

    public static void main(String[] args) {
        Set<String> results;

        ForkJoinPool pool = ForkJoinPool.commonPool();
        LinkAddedProcessor linkAddedProcessor = new LinkAddedProcessor("https://skillbox.ru");
        results = pool.invoke(linkAddedProcessor);
        pool.shutdown();


        for (String s : results) {
            System.out.println(s);
        }

        System.out.println(results.size());

    }

}

