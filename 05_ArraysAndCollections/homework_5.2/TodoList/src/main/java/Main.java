import java.util.ArrayList;
import java.util.Scanner;



public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String string = scanner.nextLine().trim();

            String[] strings = string.split(" ");
            StringBuilder stringBuilder = new StringBuilder();

            String doString;
            Integer index = null;
            String keyWord = strings[0].trim();
            strings[0] = "";

            switch (keyWord) {
                case "LIST":
                    ArrayList<String> todos = todoList.getTodos();
                    for (int i = 0; i < todos.size(); i++) {
                        System.out.println(i + " - " + todos.get(i));
                    }
                    break;

                case "ADD":
                    if (strings[1].matches("\\d*")) {
                        index = Integer.parseInt(strings[1]);
                        strings[1] = "";
                    }
                    for (String str : strings) {
                        stringBuilder.append(str).append(" ");
                    }
                    doString = stringBuilder.toString().trim();
                    if (index != null) {
                        todoList.add(index, doString);
                    } else {
                        todoList.add(doString);
                    }
                    break;

                case "DELETE":
                    index = Integer.parseInt(strings[1]);
                    strings[1] = "";
                    todoList.delete(index);
                    break;

                case "EDIT":
                    if (strings[1].matches("\\d*")) {
                        index = Integer.parseInt(strings[1]);
                        strings[1] = "";
                    }

                    for (String str : strings) {
                        stringBuilder.append(str).append(" ");
                    }
                    doString = stringBuilder.toString().trim();
                    todoList.edit(doString, index);
                    break;
            }

        }

    }
}
