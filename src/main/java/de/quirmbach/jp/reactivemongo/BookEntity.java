package de.quirmbach.jp.reactivemongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class BookEntity {

    @Id
    private String id;
    @Indexed
    private String title;
    private String author;


}
