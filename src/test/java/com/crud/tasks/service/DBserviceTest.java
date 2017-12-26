package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
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
public class DBserviceTest {
    @InjectMocks
    DBservice dBservice;

    @Mock
    TaskRepository taskRepository;

    @Test
    public void shoulGetAllTasks() {
        //Given
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(1, "Task1", "description1"));
        taskList.add(new Task(2, "Task2", "description2"));
        when(taskRepository.findAll()).thenReturn(taskList);
        //When
        List<Task> resultList = dBservice.getAllTasks();
        //Then
        assertEquals(2, resultList.size());
    }

    @Test
    public void shouldSaveTask() {
        //Given
        Task task = new Task(1, "Task1", "description1");
        when(taskRepository.save(task)).thenReturn(task);
        //When
        Task resulttask = dBservice.saveTask(task);
        //Then
        assertEquals("Task1", resulttask.getTitle());
    }

    @Test
    public void shouldGetTask() {
        //Given
        Long id = 1L;
        Task task = new Task(1, "Task1", "description1");
        when(taskRepository.findById(id)).thenReturn(Optional.of(task));
        //When
        Optional<Task> resulttask = dBservice.getTask(id);
        //Then
        assertEquals("Task1", resulttask.get().getTitle());
    }

    @Test
    public void shouldDeleteTask() {
        //Given
        Long id = 1L;
        //When
        dBservice.deleteTask(id);
        //Then
        verify(taskRepository, times(1)).delete(id);
    }
}