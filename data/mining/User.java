package ru.kpfu.itis.group905.makarov.data.mining;

import java.util.*;

public class User {
    public String name;
    public String surname;
    public byte age;
    private final int id;
    private LinkedList<Group> groups; //which groups are user subscribed to
    private ArrayList<User> friends;
    public User(String name, String surname, int id) {
        this.name = name;
        this.surname = surname;
        this.age = 0;
        this.id = id;
        this.friends = new ArrayList<>();
        this.groups = new LinkedList<>();
    }

    public static User findUserById(int id, Users users) {
        for(User user: users.getUsers()) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public int getId() {
        return this.id;
    }

    public void addFriend(User user) {
        this.friends.add(user);
        user.friends.add(this);
    }

    public void addGroup(Group group) {
        this.groups.addLast(group);
        group.subscribeUser(this);
    }

    public ArrayList<User> getFriends() {
        return this.friends;
    }

    public String getSubjectFromGroups() {
        StringBuilder result = new StringBuilder();
        Set<String> set = new HashSet<>();
        for(Group group : this.groups) {
            set.add(group.getSubject());
        }
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            result.append(it.next()).append(" ");
        }
        return result.toString().trim();
    }
}
