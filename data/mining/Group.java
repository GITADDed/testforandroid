package ru.kpfu.itis.group905.makarov.data.mining;

import java.util.LinkedList;

public class Group {
    private String subject;
    private LinkedList<User> subscribers;
    private int id;

    public Group(String subject, int id) {
        this.subject = subject;
        this.id = id;
        this.subscribers = new LinkedList<>();
    }

    public void subscribeUser(User user) {
        this.subscribers.addLast(user);
    }

    public String getSubject() {
        return this.subject;
    }
}
