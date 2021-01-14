package booksontheshelfbackend.mappers;

import booksontheshelfbackend.dtos.ReaderDto;
import booksontheshelfbackend.entities.Reader;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReaderMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Reader mapToReader (final ReaderDto readerDto){
        return modelMapper.map(readerDto, Reader.class);
    }

    public ReaderDto mapToReaderDto (final Reader reader){
        return modelMapper.map(reader, ReaderDto.class);
    }

    public List<Reader> mapToReaderList (List<ReaderDto> readerDtoList){
        return readerDtoList.stream()
                .map(this::mapToReader)
                .collect(Collectors.toList());
    }

    public List<ReaderDto> mapToReaderDtoList (List<Reader> readerList){
        return readerList.stream()
                .map(this::mapToReaderDto)
                .collect(Collectors.toList());
    }
}
