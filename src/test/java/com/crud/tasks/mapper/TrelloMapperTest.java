package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTest {
    @InjectMocks
    private TrelloMapper trelloMapper;

    @Test
    public void shouldMapToBoards() {
        //Given
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        List<TrelloListDto> trelloListDtos1 = new ArrayList<>();
        List<TrelloListDto> trelloListDtos2 = new ArrayList<>();
        List<TrelloListDto> trelloListDtos3 = new ArrayList<>();
        TrelloListDto trelloListDto1 = new TrelloListDto("1", "ListDto1", true);
        TrelloListDto trelloListDto2 = new TrelloListDto("2", "ListDto2", true);
        TrelloListDto trelloListDto3 = new TrelloListDto("3", "ListDto3", true);
        trelloListDtos1.add(trelloListDto1);
        trelloListDtos1.add(trelloListDto2);
        trelloListDtos2.add(trelloListDto3);
        trelloListDtos3.add(trelloListDto1);
        trelloListDtos3.add(trelloListDto2);
        trelloListDtos3.add(trelloListDto3);
        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("1", "Board1", trelloListDtos1);
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("2", "Board2", trelloListDtos2);
        TrelloBoardDto trelloBoardDto3 = new TrelloBoardDto("3", "Board3", trelloListDtos3);
        trelloBoardDtos.add(trelloBoardDto1);
        trelloBoardDtos.add(trelloBoardDto2);
        trelloBoardDtos.add(trelloBoardDto3);

        //When
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardDtos);

        //Then
        Assert.assertEquals(trelloBoards.size(), 3);
        Assert.assertEquals(trelloBoards.get(0).getLists().size(), 2);
        Assert.assertEquals(trelloBoards.get(1).getLists().size(), 1);
        Assert.assertEquals(trelloBoards.get(2).getLists().size(), 3);
    }

    @Test
    public void shouldMapToBoardsDto() {
        //Given
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        List<TrelloList> trelloLists1 = new ArrayList<>();
        List<TrelloList> trelloLists2 = new ArrayList<>();
        List<TrelloList> trelloLists3 = new ArrayList<>();
        TrelloList trelloList1 = new TrelloList("1", "ListDto1", true);
        TrelloList trelloList2 = new TrelloList("2", "ListDto2", true);
        TrelloList trelloList3 = new TrelloList("3", "ListDto3", true);
        trelloLists1.add(trelloList1);
        trelloLists1.add(trelloList2);
        trelloLists2.add(trelloList3);
        trelloLists3.add(trelloList1);
        trelloLists3.add(trelloList2);
        trelloLists3.add(trelloList3);
        TrelloBoard trelloBoard1 = new TrelloBoard("1", "Board1", trelloLists1);
        TrelloBoard trelloBoard2 = new TrelloBoard("2", "Board2", trelloLists2);
        TrelloBoard trelloBoard3 = new TrelloBoard("3", "Board3", trelloLists3);
        trelloBoards.add(trelloBoard1);
        trelloBoards.add(trelloBoard2);
        trelloBoards.add(trelloBoard3);

        //When
        List<TrelloBoardDto> trelloBoardDtos = trelloMapper.mapToBoardsDto(trelloBoards);

        //Then
        Assert.assertEquals(trelloBoardDtos.size(), 3);
        Assert.assertEquals(trelloBoardDtos.get(0).getLists().size(), 2);
        Assert.assertEquals(trelloBoardDtos.get(1).getLists().size(), 1);
        Assert.assertEquals(trelloBoardDtos.get(2).getLists().size(), 3);
    }

    @Test
    public void shouldMapToList() {
        //Given
        TrelloListDto trelloListDto1 = new TrelloListDto("1", "list1", true);
        TrelloListDto trelloListDto2 = new TrelloListDto("2", "list2", false);
        TrelloListDto trelloListDto3 = new TrelloListDto("3", "list3", true);
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(trelloListDto1);
        trelloListDtos.add(trelloListDto2);
        trelloListDtos.add(trelloListDto3);

        //When
        List<TrelloList> trelloLists = trelloMapper.mapToList(trelloListDtos);

        //Then
        Assert.assertEquals(trelloLists.size(), 3);
        Assert.assertEquals(trelloLists.get(0).getName(), "list1");
        Assert.assertEquals(trelloLists.get(1).getName(), "list2");
        Assert.assertEquals(trelloLists.get(2).getName(), "list3");
        Assert.assertEquals(trelloLists.get(0).getId(), "1");
        Assert.assertEquals(trelloLists.get(1).getId(), "2");
        Assert.assertEquals(trelloLists.get(2).getId(), "3");
    }

    @Test
    public void shouldMapToListDto() throws Exception {
        //Given
        TrelloList trelloList1 = new TrelloList("4", "list4", true);
        TrelloList trelloList2 = new TrelloList("5", "list5", false);
        TrelloList trelloList3 = new TrelloList("6", "list6", true);
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(trelloList1);
        trelloLists.add(trelloList2);
        trelloLists.add(trelloList3);

        //When
        List<TrelloListDto> trelloListDtos = trelloMapper.mapToListDto(trelloLists);

        //Then
        Assert.assertEquals(trelloListDtos.size(), 3);
        Assert.assertEquals(trelloListDtos.get(0).getName(), "list4");
        Assert.assertEquals(trelloListDtos.get(1).getName(), "list5");
        Assert.assertEquals(trelloListDtos.get(2).getName(), "list6");
        Assert.assertEquals(trelloListDtos.get(0).getId(), "4");
        Assert.assertEquals(trelloListDtos.get(1).getId(), "5");
        Assert.assertEquals(trelloListDtos.get(2).getId(), "6");
    }

    @Test
    public void shouldMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("card", "description", "pos", "1");

        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //Then
        Assert.assertEquals(trelloCardDto.getName(), "card");
        Assert.assertEquals(trelloCardDto.getDescription(), "description");
        Assert.assertEquals(trelloCardDto.getPos(), "pos");
        Assert.assertEquals(trelloCardDto.getListId(), "1");
    }

    @Test
    public void shouldMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("card1", "description1", "pos1", "11");

        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        Assert.assertEquals(trelloCard.getName(), "card1");
        Assert.assertEquals(trelloCard.getDescription(), "description1");
        Assert.assertEquals(trelloCard.getPos(), "pos1");
        Assert.assertEquals(trelloCard.getListId(), "11");
    }

}