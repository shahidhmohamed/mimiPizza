package com.mimipizza.command;

import org.springframework.stereotype.Component;

import java.util.Stack;

@Component
public class CommandInvoker {

    private Stack<Command> commandHistory = new Stack<>();

    // Executes a command and adds it to the history stack
    public void executeCommand(Command command) {
        command.execute();
        commandHistory.push(command);
    }

    // Undo the most recent command
    public void undoCommand() {
        if (!commandHistory.isEmpty()) {
            Command command = commandHistory.pop();
            command.undo();
        } else {
            System.out.println("No commands to undo.");
        }
    }
}

