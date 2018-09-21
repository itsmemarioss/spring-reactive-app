package br.com.itsmemario.reactiveapp.controller;

import br.com.itsmemario.reactiveapp.model.Task;
import br.com.itsmemario.reactiveapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping({"", "/", "/index"})
public class IndexController {

    private TaskService service;

    @Autowired
    public IndexController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView getIndex(){
        ModelAndView mv = new ModelAndView("index");

        mv.addObject("msg","This is a reactive program!");

        return mv;
    }

    @ModelAttribute
    public List<Task> getListOfTasks(){
        return service.findAll();
    }
}
