package com.crud.tasks.trello.client;

import com.crud.tasks.controller.BoardsNotFoundException;
import com.crud.tasks.domain.TrelloBoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class TrelloClient {

    @Value("${trello.api.endpoint.prod}")
    private String trelloApiEndpoint;

    @Value("${trello.app.key}")
    private String trelloAppKey;

    @Value("${trello.app.token}")
    private String trelloToken;

    @Value("${trello.api.username}")
    private String trellousername;

    @Autowired
    RestTemplate restTemplate;

    public List<TrelloBoardDto> getTrelloBoards() {
        Optional<TrelloBoardDto[]> boardsResponse = Optional.of(restTemplate.getForObject(getUrl(), TrelloBoardDto[].class));
        return Arrays.asList(boardsResponse.orElseThrow(BoardsNotFoundException::new));
    }

    private URI getUrl() {
        return UriComponentsBuilder.fromHttpUrl(trelloApiEndpoint + "/members/" + trellousername + "/boards")
                .queryParam("key", trelloAppKey)
                .queryParam("token", trelloToken)
                .queryParam("fields", "name,id").build().encode().toUri();

    }
}
