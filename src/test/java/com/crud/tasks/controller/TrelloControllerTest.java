package com.crud.tasks.controller;

import com.crud.tasks.domain.*;
import com.crud.tasks.trello.facade.TrelloFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TrelloControllerTest {
    @InjectMocks
    private TrelloController trelloController;

    @Mock
    private TrelloFacade trelloFacade;


    @Test
    public void shouldGetTrelloBoards() {
        //Given
        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
        List<TrelloListDto> trelloListDtoList = new ArrayList<>();
        trelloListDtoList.add(new TrelloListDto("1", "trelloList", true));
        trelloBoardDtoList.add(new TrelloBoardDto("1", "List", trelloListDtoList));
        when(trelloFacade.fetchTrelloBoards()).thenReturn(trelloBoardDtoList);
        //When
        List<TrelloBoardDto> resultList = trelloController.getTrelloBoards();
        //Then
        assertEquals(1, resultList.size());
    }

    @Test
    public void shoultCreateTrelloCardDto() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("Card1", "Description1",
                "pos1", "2");
        CreatedTrelloCardDto createdTrelloCardDto = new CreatedTrelloCardDto("1", "Card", "url");
        when(trelloFacade.createCard(trelloCardDto)).thenReturn(createdTrelloCardDto);
        //When
        CreatedTrelloCardDto createdTrelloCardDtoResult = trelloController.createTrelloCard(trelloCardDto);
        //Then
        assertEquals("1" , createdTrelloCardDtoResult.getId());
        assertEquals("Card" , createdTrelloCardDtoResult.getName());
    }

}