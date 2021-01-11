package de.quirmbach.jp.reactivemongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookRepository bookRepository;

    @GetMapping()
    public Flux<BookEntity> getAll() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<BookEntity> getBookById(@PathVariable String id) {
        return bookRepository.findById(id);
    }

    @PostMapping
    public Mono<BookEntity> create(@RequestBody BookEntity bookEntity) {
        return bookRepository.save(bookEntity);
    }

    @GetMapping("/search/{title}")
    public Flux<BookEntity> searchByTitle(@PathVariable String title) {
        return bookRepository.findByTitle(title);
    }
}
