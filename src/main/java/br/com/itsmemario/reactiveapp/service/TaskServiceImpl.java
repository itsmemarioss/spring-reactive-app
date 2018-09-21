package br.com.itsmemario.reactiveapp.service;

import br.com.itsmemario.reactiveapp.model.Task;
import br.com.itsmemario.reactiveapp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository repository;

    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Task t) {
        repository.save(t);
    }

    @Override
    public List<Task> findAll() {
        return repository.findAll();
    }
}
