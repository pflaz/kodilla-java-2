package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class Queue implements Observable {
    private String student;
    private List<String> answers;
    private List<Observer> observers;

    public Queue(String student) {
        this.student = student;
        this.answers = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public String getStudent() {
        return student;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void addAnswer(String answer) {
        answers.add(answer);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer: observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
}
