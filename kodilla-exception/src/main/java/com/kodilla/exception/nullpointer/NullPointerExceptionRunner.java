package com.kodilla.exception.nullpointer;

public class NullPointerExceptionRunner {

    public static void main(String[] args) {
        User user = null;

       // user = new User("username");

        MessageSender messageSender = new MessageSender();
        try {
            messageSender.sendMessageTo(user, "Test message");
        } catch (MessageNotSendException e) {
            System.out.println("Message is not send, but the program is running. Exception: " + e);
        }
        System.out.println("next instructions");
    }
}
