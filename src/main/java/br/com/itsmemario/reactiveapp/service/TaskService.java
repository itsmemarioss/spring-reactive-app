package br.com.itsmemario.reactiveapp.service;

import br.com.itsmemario.reactiveapp.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TaskService {

    void save(Task t);
    List<Task> findAll();

}
