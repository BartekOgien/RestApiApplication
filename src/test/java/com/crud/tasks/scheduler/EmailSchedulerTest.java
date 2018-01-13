package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(MockitoJUnitRunner.class)
public class EmailSchedulerTest {

    @InjectMocks
    private EmailScheduler emailScheduler;

    @Mock
    private AdminConfig adminConfig;

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private SimpleEmailService simpleEmailService;

    @Test
    public void shouldSendInformationEmail() {
        //Given
        when(adminConfig.getAdminMail()).thenReturn("admin@mail.com");
        //When
        emailScheduler.sendInformationEmail();
        //Then
        verify(simpleEmailService, times(1)).sendTaskNumbers(any(Mail.class));
    }
}