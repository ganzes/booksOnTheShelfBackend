package booksontheshelfbackend.mappers;

import booksontheshelfbackend.dtos.BookDto;
import booksontheshelfbackend.entities.Book;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Book mapToBook (final BookDto bookDto){
        return modelMapper.map(bookDto, Book.class);
    }

    public BookDto mapToBookDto (final Book book){
        return modelMapper.map(book, BookDto.class);
    }

    public List<Book> mapToBookList (List<BookDto> bookDtoList){
        return bookDtoList.stream()
                .map(this::mapToBook)
                .collect(Collectors.toList());
    }

    public List<BookDto> mapToBookDtoList (List<Book> bookList){
        return bookList.stream()
                .map(this::mapToBookDto)
                .collect(Collectors.toList());
    }
}
