import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {


        int kernelCount = Runtime.getRuntime().availableProcessors();

        String srcFolder = "D:\\Ирина\\Выпускной!!!";
        String dstFolder = "B:\\dst";
        File srcDir = new File(srcFolder);
        File[] files = srcDir.listFiles();
        long start = System.currentTimeMillis();

        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(kernelCount);

        for (File f : files) {
            ImageResizer resizer = new ImageResizer(dstFolder, f, 300);
            threadPoolExecutor.execute(resizer);
        }

        threadPoolExecutor.shutdown();

        try {
            threadPoolExecutor.awaitTermination(15, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Duration: " + (System.currentTimeMillis() - start) + " Thread name: " + Thread.currentThread().getName());
    }
}


