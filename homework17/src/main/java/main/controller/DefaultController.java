package main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class DefaultController {

    @RequestMapping("/")
    public String index(){
        return "todos";

    }
}
