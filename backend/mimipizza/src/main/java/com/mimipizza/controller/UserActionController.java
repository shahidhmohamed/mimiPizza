package com.mimipizza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mimipizza.command.CommandInvoker;
import com.mimipizza.command.PlaceOrderCommand;
import com.mimipizza.command.ProvideFeedbackCommand;

@RestController
@RequestMapping("/userActions")
public class UserActionController {

    @Autowired
    private CommandInvoker commandInvoker;

    @Autowired
    private PlaceOrderCommand placeOrderCommand;

    @Autowired
    private ProvideFeedbackCommand provideFeedbackCommand;

    @PostMapping("/placeOrder")
    public String placeOrder(@RequestParam String pizzaName) {
        placeOrderCommand.setPizzaName(pizzaName);
        commandInvoker.executeCommand(placeOrderCommand);
        return "Order placed for: " + pizzaName;
    }

    @PostMapping("/provideFeedback")
    public String provideFeedback(@RequestParam String feedback) {
        provideFeedbackCommand.setFeedback(feedback);
        commandInvoker.executeCommand(provideFeedbackCommand);
        return "Feedback provided: " + feedback;
    }

    @PostMapping("/undo")
    public String undo() {
        commandInvoker.undoCommand();
        return "Last action undone.";
    }
}
