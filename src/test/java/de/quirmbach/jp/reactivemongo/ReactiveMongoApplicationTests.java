package de.quirmbach.jp.reactivemongo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@DataMongoTest
@ExtendWith(SpringExtension.class)
class ReactiveMongoApplicationTests {

	@Autowired
	private IBookRepository repository;

	@Test
	void testCreate() {
		BookEntity bookEntity = new BookEntity();
		bookEntity.setAuthor("jp");

		BookEntity createdBook = repository.save(bookEntity).block();

		Assertions.assertThat(createdBook).isNotNull();
		Assertions.assertThat(createdBook.getId()).isNotBlank();
		Assertions.assertThat(createdBook.getAuthor()).isEqualTo(bookEntity.getAuthor());
	}

	@Test
	void testSearchByTitle() {
		BookEntity bookEntity = new BookEntity();
		bookEntity.setTitle("new Title");
		repository.save(bookEntity).block();

		List<BookEntity> result = repository.findByTitle(bookEntity.getTitle()).collectList().block();
		Assertions.assertThat(result).hasSize(1);
	}

}
