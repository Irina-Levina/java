package main.controller;


import main.model.ToDo;
import main.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class TodoController {

    public TodoRepository todoRepository;

   // @Autowired
    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("todos")
    public String getToDos(Model model) {
        List<ToDo> toDos = todoRepository.findAll();
        model.addAttribute("todoList", toDos);
        return "todos";
    }


    @GetMapping("/create-task")
    public String createTask(Model model) {
       model.addAttribute(new ToDo());
        return "create-task";
    }

    @PostMapping("/create-task")
    public String add(ToDo toDo) {
        todoRepository.save(toDo);
        return "redirect:/todos";
    }

    @GetMapping("/update-task/{id}")
    public String update(Model model, @PathVariable("id") Integer id) {
        ToDo toDo = todoRepository.findById(id).get();
        model.addAttribute(toDo);
        return "/update-task";
    }

    @PostMapping("/update-task/{id}")
    public String editToDo(@RequestParam String id, @RequestParam String description, @RequestParam String endDate ) {
        ToDo toDo = todoRepository.findById(Integer.parseInt(id)).get();
        toDo.setDescription(description);
        toDo.setEndDate(LocalDate.parse(endDate));
        todoRepository.save(toDo);
        return "redirect:/todos";
    }

    @GetMapping("/delete-task/{id}")
    public String delete(@PathVariable("id") Integer id) {
        ToDo toDo = todoRepository.findById(id).get();
        todoRepository.delete(toDo);
        return "redirect:/todos";
    }

}
