package br.com.itsmemario.reactiveapp.service;

import br.com.itsmemario.reactiveapp.model.Task;
import br.com.itsmemario.reactiveapp.repository.reactive.TaskReactiveRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class TaskReativeService implements TaskService {

    private TaskReactiveRepository repository;

    public TaskReativeService(TaskReactiveRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Task t) {

        if(t.getId() != null && t.getId().isEmpty())
            t.setId(null);

        repository.save(t).block();
    }

    @Override
    public List<Task> findAll() {
        return repository.findAll().collectList().block();
    }

    @Override
    public void delete(Task t) {
        repository.delete(t);
    }

    @Override
    public Optional<Task> findById(String id) {
        return Optional.ofNullable(repository.findById(id).block());
    }
}
