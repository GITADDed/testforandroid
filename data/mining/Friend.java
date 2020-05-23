package ru.kpfu.itis.group905.makarov.data.mining;

import java.util.HashMap;
import java.util.ArrayList;

public class Friend {
    private HashMap<User, ArrayList<User>> friends = new HashMap<>();

    public Friend(Users users) {
        for(User user : users.getUsers()) {
            this.friends.put(user, user.getFriends());
        }
    }

    public HashMap<User, ArrayList<User>> getFriends() {
        return this.friends;
    }
}
