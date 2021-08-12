
import java.io.UncheckedIOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите путь до папки:");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String path = scanner.nextLine();
            try {
                long sumLengthFile = FileUtils.calculateFolderSize(path);
                System.out.println("Размер папки: " + path + " составляет " + (float)sumLengthFile/1024 + "КБ или " +
                        +sumLengthFile/1048576 +  "МБ или " + (float)sumLengthFile/(1024*1024*1024) + "ГБ");
            } catch (UncheckedIOException uncheckedIOException) {  //AccessDeniedException не разрешает поставить
                System.out.println(uncheckedIOException.getCause());
            }

        }

    }
}
