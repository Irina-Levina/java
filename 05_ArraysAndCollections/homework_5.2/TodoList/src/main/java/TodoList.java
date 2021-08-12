import java.util.ArrayList;

public class TodoList {

    private ArrayList<String> toDoList;
    private int count;

    public TodoList() {
        toDoList = new ArrayList<>();
    }

    public void add(String todo) {
        toDoList.add(todo);
        count = toDoList.size();
        System.out.println("Добавлено дело: " + toDoList.get(count - 1));
    }

    public void add(int index, String todo) {
        if ((index >= 0) & (index <= toDoList.size())) {
            toDoList.add(index, todo);
            System.out.println("Добавлено дело: " + toDoList.get(index));
        } else if (index > toDoList.size()) {
            toDoList.add(todo);
            System.out.println("Добавлено дело: " + toDoList.get(count - 1));
        }
    }

    public void edit(String todo, int index) {
        if (index >= 0 & index < toDoList.size()) {
            System.out.println("Дело - \"" + toDoList.get(index) + "\" заменено на - \"" + todo.trim() + "\"");
            toDoList.set(index, todo);
        }
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
    }

    public void delete(int index) {
        if ((index >= 0 & index < toDoList.size())) {
            System.out.println("Дело - \"" + toDoList.get(index) + "\" удалено");
            toDoList.remove(index);
        }

        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел
        return toDoList;
    }
}