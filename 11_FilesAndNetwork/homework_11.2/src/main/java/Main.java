import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Какую папку копировать ? ");
        String pathSource = scanner.nextLine();
        System.out.println("Укажите путь для копирования: ");
        String targetPath = scanner.nextLine();

        try {
            FileUtils.copyFolder(pathSource,targetPath);
            System.out.println("Копирование завершено!");
        }catch (IOException ioException){
            System.out.println(ioException.getMessage());
        }

    }

}
