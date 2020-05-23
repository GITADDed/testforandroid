package ru.kpfu.itis.group905.makarov.data.mining;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class SearchFriends {
    public static void main(String[] args) {
        Friend friends = generateFriend(generateGroupSubs());
        Set<User> set = friends.getFriends().keySet();
        Iterator<User> it = set.iterator();
        User userForSearch = it.next();
        ArrayList<User> usersFriends = friends.getFriends().get(userForSearch);
        for(User user : usersFriends) {
            if (isThisUserHaveYourSubjects(userForSearch, user)) {
                System.out.println(user.getId());
            }
        }
    }

    public static Users generateUsers() {
        int[] id = new int[20];
        for (int i = 0; i < id.length; i++) {
            id[i] = (int) ( Math.random() * 1371 );
        }
        return new Users(id);
    }

    public static Friend generateFriend(Users users) {
        Iterator<User> iter = users.getUsers().listIterator();
        try {

            for (User user : users.getUsers()) {

                for (int i = 0; i < 5; i++) {
                    iter.next().addFriend(user);
                }

                iter = users.getUsers().listIterator(0);
            }
        }
        catch (NoSuchElementException | NullPointerException e) {
            e.printStackTrace();
        }

        return new Friend(users);
    }

    public static Users generateGroupSubs() {
        Users users = generateUsers();
        Group[] groups = new Group[4];
        groups[0] = new Group("cars", 17732);
        groups[1] = new Group("cook", 17742);
        groups[2] = new Group("rest", 17752);
        groups[3] = new Group("blog", 17762);

        for(User user : users.getUsers()) {
            int end = (int) ( Math.random() * 3 );
            for (int i = 0; i < end; i++) {
                user.addGroup(groups[i]);
            }
        }

        return users;
    }

    public static boolean isThisUserHaveYourSubjects(User me, User friend) {
        String mySubjects[] = me.getSubjectFromGroups().split(" ");
        String friendsSubjects[] = friend.getSubjectFromGroups().split(" ");

        for (int i = 0; i < mySubjects.length; i++) {

            for (int j = 0; j < friendsSubjects.length; j++) {
                if (mySubjects[i].equals(friendsSubjects[j])) {
                    return true;
                }
            }

        }

        return false;
    }
}
