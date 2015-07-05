package eu.softelo.microservices.qbit.model;

import java.util.Date;

public class TodoItem {
    private final String description;
    private final String name;
    private final Date due;

    public TodoItem(String description, String name, Date due) {
        this.description = description;
        this.name = name;
        this.due = due;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public Date getDue() {
        return due;
    }
}
