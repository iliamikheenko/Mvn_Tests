package serializer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import model.Book;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BookSerializer {
    private final ObjectMapper mapper;

    public BookSerializer(ObjectMapper mapper) {
        this.mapper = mapper;
        this.mapper.registerModule(new JavaTimeModule());
    }

    public void serialize(File file, Book book) throws IOException {
        this.mapper.writeValue(file,book);
    }
    public Book deserialize(File file) throws IOException {
        return this.mapper.readValue(file, Book.class);
    }
    public void serializeList(File file, List<Book> books) throws IOException{
        this.mapper.writeValue(file, books);
    }
    public List<Book> deserializeList(File file) throws IOException {
        return this.mapper.readValue(file, new TypeReference<>(){});
    }
}
