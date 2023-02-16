package serializer;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookSerializerTest {
    private final BookSerializer jsonSerializer = new BookSerializer(new YAMLMapper());
    private Book fire;
    private final String path = "src/test/java/tmp/";
    private final String fileName = "fire.yaml";
    @BeforeEach
    public void init(){
        fire = Book.builder()
                .isbn("9780544003415")
                .numOfPages(577)
                .authorName("J.R.R.")
                .publishingHouse("Mariner Books")
                .build();
    }
    @Test
    void serialize() throws IOException {
        File bookData = new File(path + fileName);
        jsonSerializer.serialize(bookData, fire);
        Book deserializedFire =  jsonSerializer.deserialize(bookData);
        assertEquals(fire, deserializedFire);
        bookData.delete();
    }

    @Test
    void deserialize() throws IOException {
        File bookData = new File(path + fileName);
        jsonSerializer.serialize(bookData, fire);
        Book deserializedFire =  jsonSerializer.deserialize(bookData);
        assertEquals(fire, deserializedFire);
        bookData.delete();
    }

    @Test
    void serializeList() throws IOException {
        List<Book> books = List.of(
                fire,
                Book.builder()
                        .isbn("125436544045")
                        .numOfPages(224)
                        .authorName("J.R.R.")
                        .publishingHouse("Mariner Books")
                        .build()
        );
        File bookData = new File(path + fileName);
        jsonSerializer.serializeList(bookData,books);
        List<Book> booksDeserialized = jsonSerializer.deserializeList(bookData);
        assertEquals(books,booksDeserialized);
        bookData.delete();

    }

    @Test
    void deserializeList() throws IOException {
        List<Book> books = List.of(
                fire,
                Book.builder()
                        .isbn("125436544045")
                        .numOfPages(224)
                        .authorName("J.R.R.")
                        .publishingHouse("Mariner Books")
                        .build()
        );
        File bookData = new File(path + fileName);
        jsonSerializer.serializeList(bookData,books);
        List<Book> booksDeserialized = jsonSerializer.deserializeList(bookData);
        assertEquals(books,booksDeserialized);
        bookData.delete();
    }
}