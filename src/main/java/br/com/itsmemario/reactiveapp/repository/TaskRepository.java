package br.com.itsmemario.reactiveapp.repository;

import br.com.itsmemario.reactiveapp.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {
}
