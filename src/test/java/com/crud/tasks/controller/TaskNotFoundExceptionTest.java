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

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TaskNotFoundExceptionTest {
    @InjectMocks
    TaskController taskController;

    @Mock
    DBservice dBservice;

    @Mock
    TaskMapper taskMapper;

    @Test(expected = TaskNotFoundException.class)
    public void shouldThrowTaskNotFoundException() throws TaskNotFoundException{
        //Given
        TaskDto taskDto = new TaskDto(1, "Title", "Content");
        Task task = new Task(1, "Title", "Content");
        Long taskId = 1L;
        when(dBservice.getTask(taskId)).thenThrow(TaskNotFoundException.class);
        when(taskMapper.mapToTaskDto(task)).thenReturn(taskDto);
        //When
        TaskDto resultTask = taskController.getTask(taskId);
    }
}