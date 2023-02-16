package serializer;

import com.fasterxml.jackson.databind.json.JsonMapper;
import model.Author;
import model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookSerializerTest {
    private final BookSerializer jsonSerializer = new BookSerializer(new JsonMapper());
    private Book fire;
    private Author tolkien;
    private final String path = "src/test/java/tmp/";
    private final String fileName = "fire.json";
    @BeforeEach
    public void init(){
        tolkien = new Author("Tolkien",46);
        fire = Book.builder()
                .isbn("9780544003415")
                .numOfPages(577)
                .author(tolkien)
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
                        .author(tolkien)
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
                        .author(tolkien)
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