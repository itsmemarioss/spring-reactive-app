package br.com.itsmemario.reactiveapp.service;

import br.com.itsmemario.reactiveapp.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    void save(Task t);
    List<Task> findAll();
    void delete(Task t);

    Optional<Task> findById(String id);
}
