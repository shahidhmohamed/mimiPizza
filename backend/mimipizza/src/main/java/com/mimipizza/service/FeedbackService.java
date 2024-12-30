package com.mimipizza.service;

import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    public void provideFeedback(String feedback) {
        System.out.println("Providing feedback: " + feedback);
    }

    public void undoFeedback(String feedback) {
        System.out.println("Undoing feedback: " + feedback);
    }
}