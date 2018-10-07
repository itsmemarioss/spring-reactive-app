package br.com.itsmemario.reactiveapp.controller;

import br.com.itsmemario.reactiveapp.model.Task;
import br.com.itsmemario.reactiveapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

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

    @GetMapping("/{id}")
    public ModelAndView edit(@PathVariable String id){
        ModelAndView mv = new ModelAndView("form");
        Optional<Task> task = service.findById(id);

        mv.addObject("task", task.get());

        return mv;
    }

    @GetMapping("/show/{id}")
    public ModelAndView show(@PathVariable String id){
        ModelAndView mv = new ModelAndView("show");
        Optional<Task> task = service.findById(id);

        if(!task.isPresent()){
            mv.setStatus(HttpStatus.NOT_FOUND);
            mv.setViewName("404");
            return mv;
        }

        mv.addObject("task", task.get());

        return mv;
    }


}
