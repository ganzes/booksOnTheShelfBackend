package booksontheshelfbackend.mappers;

import booksontheshelfbackend.dtos.BookDto;
import booksontheshelfbackend.entities.Book;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Autowired
    private ModelMapper modelMapper;

    private Book mapToBook (final BookDto bookDto){
        return modelMapper.map(bookDto, Book.class);
    }

    private BookDto mapToBookDto (final Book book){
        return modelMapper.map(book, BookDto.class);
    }

    private List<Book> mapToBookList (List<BookDto> bookDtoList){
        return bookDtoList.stream()
                .map(this::mapToBook)
                .collect(Collectors.toList());
    }

    private List<BookDto> mapToBookDtoList (List<Book> bookList){
        return bookList.stream()
                .map(this::mapToBookDto)
                .collect(Collectors.toList());
    }
}
