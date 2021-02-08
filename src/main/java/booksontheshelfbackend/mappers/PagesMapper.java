package booksontheshelfbackend.mappers;

import booksontheshelfbackend.dtos.PagesDto;
import booksontheshelfbackend.entities.Pages;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component
public class PagesMapper {
    @Autowired
    private ModelMapper modelMapper;

    public Pages mapToPages (final PagesDto pagesDto){
        return modelMapper.map(pagesDto, Pages.class);
    }

    public PagesDto mapToPagesDto (final Pages pages){
        return modelMapper.map(pages, PagesDto.class);
    }

    public List<Pages> mapToPagesList (List<PagesDto> pagesDtoList){
        return pagesDtoList.stream()
                .map(this::mapToPages)
                .collect(Collectors.toList());
    }

    public List<PagesDto> mapToPagesDtoList (List<Pages> pagesList){
        return pagesList.stream()
                .map(this::mapToPagesDto)
                .collect(Collectors.toList());
    }

    public Set<Pages> mapToPagesSet (Set<PagesDto> pagesDtoSet){
        return pagesDtoSet.stream()
                .map(this::mapToPages)
                .collect(Collectors.toSet());
    }

    public Set<PagesDto> mapToPagesDtoSet (Set<Pages> pagesSet){
        return pagesSet.stream()
                .map(this::mapToPagesDto)
                .collect(Collectors.toSet());
    }
}
