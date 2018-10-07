package br.com.itsmemario.reactiveapp.repository.reactive;


import br.com.itsmemario.reactiveapp.model.Task;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TaskReactiveRepository extends ReactiveMongoRepository<Task, String> {

}
