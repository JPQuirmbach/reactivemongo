package de.quirmbach.jp.reactivemongo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface IBookRepository extends ReactiveMongoRepository<BookEntity, String> {

    Flux<BookEntity> findByTitle(String title);
}
