package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DBservice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
public class TaskControllerTest {
    @InjectMocks
    private TaskController taskController;

    @Mock
    private DBservice dBservice;

    @Mock
    private TaskMapper taskMapper;

    @Test
    public void shouldGetTasks() {
        //Given
        List<TaskDto> taskDtoList = new ArrayList<>();
        taskDtoList.add(new TaskDto(1, "Title", "Content"));
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(1, "Title", "Content"));
        when(dBservice.getAllTasks()).thenReturn(taskList);
        when(taskMapper.mapToTaskDtoList(taskList)).thenReturn(taskDtoList);
        //When
        List<TaskDto> resultList = taskController.getTasks();
        //Then
        assertEquals(1, resultList.size());
    }

    @Test
    public void shouldGetTask() throws TaskNotFoundException {
        //Given
        TaskDto taskDto = new TaskDto(1, "Title", "Content");
        Task task = new Task(1, "Title", "Content");
        Long taskId = 1L;
        when(dBservice.getTask(taskId)).thenReturn(Optional.of(task));
        when(taskMapper.mapToTaskDto(task)).thenReturn(taskDto);
        //When
        TaskDto resultTask = taskController.getTask(taskId);
        //Then
        assertEquals(1, resultTask.getId());
        assertEquals("Title", resultTask.getTitle());
        assertEquals("Content", resultTask.getContent());
    }

    @Test
    public void shouldUpdateTask() {
        //Given
        TaskDto taskDto = new TaskDto(1, "Title", "Content");
        Task task = new Task(1, "Title", "Content");
        when(taskMapper.mapToTask(taskDto)).thenReturn(task);
        when(dBservice.saveTask(task)).thenReturn(task);
        when(taskMapper.mapToTaskDto(task)).thenReturn(taskDto);
        //When
        TaskDto resultTask = taskController.updateTask(taskDto);
        //Then
        assertEquals(1, resultTask.getId());
        assertEquals("Title", resultTask.getTitle());
        assertEquals("Content", resultTask.getContent());
    }

    @Test
    public void shouldDeleteTask() {
        //Given
        Long taskid = 1L;
        //When
        taskController.deleteTask(taskid);
        //Then
        verify(dBservice, times(1)).deleteTask(taskid);
    }

    @Test
    public void shouldCreateTask() {
        //Given
        TaskDto taskDto = new TaskDto(1, "Title", "Content");
        Task task = new Task(1, "Title", "Content");
        when(taskMapper.mapToTask(taskDto)).thenReturn(task);
        //When
        taskController.createTask(taskDto);
        //Then
        verify(dBservice, times(1)).saveTask(task);
    }
}