package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TaskMapperTest {
    @InjectMocks
    TaskMapper taskMapper;

    @Test
    public void shouldMapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1, "Title", "Content");
        //When
        Task task = taskMapper.mapToTask(taskDto);
        //Then
        assertEquals(1, task.getId());
        assertEquals("Title", task.getTitle());
        assertEquals("Content", task.getContent());
    }

    @Test
    public void shouldMapToTaskDto() {
        //Given
        Task task = new Task(1, "Title1", "Content1");
        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        //Then
        assertEquals(1, taskDto.getId());
        assertEquals("Title1", taskDto.getTitle());
        assertEquals("Content1", taskDto.getContent());
    }

    @Test
    public void shouldMapToTaskDtoList() {
        //Given
        Task task1 = new Task(1, "Title1", "Content1");
        Task task2 = new Task(2, "Title2", "Content2");
        List<Task> taskList = new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);
        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);
        //Then
        assertEquals(2, taskDtoList.size());
        assertEquals("Title1", taskDtoList.get(0).getTitle());
        assertEquals("Title2", taskDtoList.get(1).getTitle());
    }

    @Test
    public void shouldMapEmptyList() {
        //Given
        List<Task> taskList = new ArrayList<>();
        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);
        //Then
        assertNotNull(taskDtoList);
        assertEquals(0, taskDtoList.size());
    }

}