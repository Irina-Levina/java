import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String boxes = scanner.nextLine();
        int maxCountBox = 27;
        int maxCountContainer = 12;
        int countContainers;
        int countCargo;

        if (Integer.parseInt(boxes) % maxCountBox != 0) {
            countContainers = Integer.parseInt(boxes) / maxCountBox + 1;
        } else {
            countContainers = Integer.parseInt(boxes) / maxCountBox;//количество контейнеров
        }

        if (countContainers % maxCountContainer != 0) {
            countCargo = countContainers / maxCountContainer + 1;
        } //кол-во машин
        else {
            countCargo = countContainers / maxCountContainer;
        }

        for (int zz = 0; zz < Integer.parseInt(boxes); zz++) {
            if (zz % (maxCountBox * maxCountContainer) == 0) {
                System.out.println("Грузовик: " + (zz / (maxCountBox * maxCountContainer) + 1));
            }
            if (zz % maxCountBox == 0) {
                System.out.println("\tКонтейнер: " + ((zz / maxCountBox) + 1));
            }
            System.out.println("\t\tЯщик: " + (zz + 1));
        }
        System.out.println("Необходимо:" + "\r\nгрузовиков - " + countCargo + " шт.\nконтейнеров - " + countContainers + " шт.");


        // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
        // пример вывода при вводе 2
        // для отступа используйте табуляцию - \t

        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */
    }

}
