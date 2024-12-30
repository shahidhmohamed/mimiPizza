package com.mimipizza.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mimipizza.service.FeedbackService;

@Component
public class ProvideFeedbackCommand implements Command {

    private FeedbackService feedbackService;
    private String feedback;

    @Autowired
    public ProvideFeedbackCommand(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public void execute() {
        feedbackService.provideFeedback(feedback);
    }

    @Override
    public void undo() {
        feedbackService.undoFeedback(feedback);
    }
}
