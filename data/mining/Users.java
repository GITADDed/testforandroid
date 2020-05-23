package ru.kpfu.itis.group905.makarov.data.mining;

import java.util.LinkedList;

public class Users {
    LinkedList<User> users = new LinkedList<>();

    public Users(int[] ids) {
        for (int id : ids) {
            this.users.addLast(new User("Fill", "Jackson", id));
        }
    }

    public LinkedList<User> getUsers() {
        return this.users;
    }
}
