package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.config.InfoConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailCreatorService {

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private InfoConfig infoConfig;

    public String buildTrelloCardEmail(String message) {
        List<String> funcionality = new ArrayList<>();
        funcionality.add("You can manage your tasks");
        funcionality.add("Provides connection with Trello account");
        funcionality.add("Application allows sending tasks to Trello");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8888/tasks_frontend");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("goodbye", "Kodilla team");
        context.setVariable("info_details", infoConfig.getAppInfo());
        context.setVariable("show_button", false);
        context.setVariable("is_friend", false);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("application_funcionality", funcionality);
        return templateEngine.process("mail/created-trello-card-mail", context);
    }

    public String buildTaskNumbersEmail(String message) {
        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8888/tasks_frontend");
        context.setVariable("button", "Visit our website");
        context.setVariable("goodbye", "Kodilla team");
        context.setVariable("info_details", infoConfig.getAppInfo());
        context.setVariable("show_button", true);
        context.setVariable("admin_config", adminConfig);
        return templateEngine.process("mail/tasks-number-mail", context);
    }
}
