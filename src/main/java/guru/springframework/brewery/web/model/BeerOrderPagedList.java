package guru.springframework.brewery.web.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;


public class BeerOrderPagedList extends PageImpl<BeerOrderDto> {
    public BeerOrderPagedList(List<BeerOrderDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public BeerOrderPagedList(List<BeerOrderDto> content) {
        super(content);
    }
}

