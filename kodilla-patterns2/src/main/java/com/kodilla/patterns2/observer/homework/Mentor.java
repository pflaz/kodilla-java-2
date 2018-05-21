package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {
    private String name;
    private int notificationsCount;

    public Mentor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNotificationsCount() {
        return notificationsCount;
    }

    @Override
    public void update(Queue queue) {
        System.out.println("Hello, " + name + ", your student " + queue.getStudent() + " put the answer to his queue (total answers in his queue: " + queue.getAnswers().size() + ").");
        notificationsCount++;
    }
}
