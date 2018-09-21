package br.com.itsmemario.reactiveapp.controller;

import br.com.itsmemario.reactiveapp.model.Task;
import br.com.itsmemario.reactiveapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/task")
public class TaskController {

    private TaskService service;

    @Autowired
    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping("/new")
    public ModelAndView getForm(){
        ModelAndView mv = new ModelAndView("form");
        mv.addObject("task", new Task());
        return mv;
    }

    @PostMapping("/new")
    public ModelAndView save(Task task){
        ModelAndView mv = new ModelAndView("redirect:/index");

        service.save(task);

        return mv;
    }


}
