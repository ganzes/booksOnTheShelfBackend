package booksontheshelfbackend.mappers;

import booksontheshelfbackend.dtos.BookcaseDto;
import booksontheshelfbackend.entities.Bookcase;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookcaseMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Bookcase mapToBookcase (final BookcaseDto bookcaseDto){
        return modelMapper.map(bookcaseDto, Bookcase.class);
    }

    public BookcaseDto mapToBookcaseDto (final Bookcase bookcase){
        return modelMapper.map(bookcase, BookcaseDto.class);
    }

    public List<Bookcase> mapToBookcaseList (List<BookcaseDto> bookcaseDtoList){
        return bookcaseDtoList.stream()
                .map(this::mapToBookcase)
                .collect(Collectors.toList());
    }

    public List<BookcaseDto> mapToBookcaseDtoList (List<Bookcase> bookcaseList){
        return bookcaseList.stream()
                .map(this::mapToBookcaseDto)
                .collect(Collectors.toList());
    }
    
}
