package com.kodilla.patterns.prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class TaskList {
    private final String name;
    private final List<Task> tasks = new ArrayList<>();

    public TaskList(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("    List [" + name + "]");
        for (Task task : tasks) {
            s.append("\n").append(task.toString());
        }
        return s.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskList taskList = (TaskList) o;
        return Objects.equals(name, taskList.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
