package practice20;

import acm.program.ConsoleProgram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

        /* class: FriendReader */

/**
 * A program that reads friendships performs a few operations on them.
 */
@SuppressWarnings("serial")
public class FriendReader extends ConsoleProgram {

    public void run() {
        setFont("consolas-20");

        Map<String, ArrayList<String>> friendLists = getFriendLists();
        printFriendMap(friendLists);
        printMostPopular(friendLists);
        printNoMutualFriends(friendLists);
    }

    /*
     * Method: printNoMutualFriends(Map<String, ArrayList<String>> friendLists)
     */

    /**
     * Prints a pair of people who have no mutual friends. If there is no such
     * pair, prints a corresponding message.
     */
    private void printNoMutualFriends(Map<String, ArrayList<String>> friendLists) {
        String noMutuals1 = null, noMutuals2 = null; // initialy both people are
        // null so that if we
        // don't find any pairs
        // they will stay as
        // nulls and we will be
        // able to compare them
        // to determine whether
        // we found a pair.

        for (String person1 : friendLists.keySet()) {
            for (String person2 : friendLists.keySet()) {
                if (!person1.equals(person2) // we obviously skip a pair if
                        // their names are same or they
                        // are friends.
                        && !areFriends(person1, person2, friendLists)
                        && haveNoMutualFriends(person1, person2, friendLists)) {
                    noMutuals1 = person1;
                    noMutuals2 = person2;
                    break;
                }
            }
        }
        if (noMutuals1 == null) {
            println("There are no people who don't have any mutual friends.");
        } else {
            println(noMutuals1 + " and " + noMutuals2 + " have no mutual friends!");
        }
    }

    /*
     * Method: areFriends(String person1, String person2, Map<String,
     * ArrayList<String>> friendLists)
     */

    /**
     * Returns whether passed people are friends based on the passed friendlist
     * map.
     */
    private boolean areFriends(String person1, String person2, Map<String, ArrayList<String>> friendLists) {
        return friendLists.get(person1).contains(person2);
    }

    /*
     * Method: haveNoMutualFriends(String person1, String person2, Map<String,
     * ArrayList<String>> friendLists)
     */

    /**
     * Returns whether two people have no mutual friends based on passed
     * friendlist map.
     */
    private boolean haveNoMutualFriends(String person1, String person2, Map<String, ArrayList<String>> friendLists) {
        ArrayList<String> friendsOfPerson1 = friendLists.get(person1);
        for (String friend : friendsOfPerson1) {
            if (areFriends(friend, person2, friendLists))
                return false;
        }
        return true;
    }

    /* Method: printMostPopular(Map<String, ArrayList<String>> friendLists) */

    /**
     * Finds and prints most popular person in passed map.
     */
    private void printMostPopular(Map<String, ArrayList<String>> friendLists) {

        String mostPopular = "";
        int maxFriends = -1;
        for (String person : friendLists.keySet()) {
            int currSize = friendLists.get(person).size();
            if (currSize > maxFriends) {
                maxFriends = currSize;
                mostPopular = person;
            }
        }
        println("The most popular person is " + mostPopular + " with " + maxFriends + " friends!");
    }

    /* Method: printFriendMap(Map<String, ArrayList<String>> friendLists) */

    /**
     * Prints names of every person and their friends in the passed map.
     */
    private void printFriendMap(Map<String, ArrayList<String>> friendLists) {
        println("Here are all the friendships:");
        for (String person : friendLists.keySet()) {

            println(person + ": " + friendLists.get(person).toString());
        }
    }

    /* Method: getFriendLists() */

    /**
     * Reads lines of friendships from console and returns correspondning map.
     */
    private Map<String, ArrayList<String>> getFriendLists() {
        println("Enter Friendships: ");
        Map<String, ArrayList<String>> res = new HashMap<String, ArrayList<String>>();
        while (true) {
            String line = readLine("? ");
            if (line.length() == 0)
                break;
            addToFriendLists(res, line);
        }
        return res;
    }

    /*
     * Method: addToFriendLists(Map<String, ArrayList<String>> map, String line)
     */

    /**
     * Adds single read line to friendship map. Line must be formatted as
     * 'name1' + space + 'name2'
     */
    private void addToFriendLists(Map<String, ArrayList<String>> map, String line) {
        String friendA = line.substring(0, line.indexOf(' '));
        String friendB = line.substring(line.indexOf(' ') + 1);
        addToFriends(map, friendA, friendB);
        addToFriends(map, friendB, friendA);
    }

    /*
     * Method: addToFriends(Map<String, ArrayList<String>> map, String person,
     * String newFriend)
     */

    /**
     * Adds a new friend if it doesn't already exist in person's friendlist.
     */
    private void addToFriends(Map<String, ArrayList<String>> map, String person, String newFriend) {
        if (!map.containsKey(person)) {
            map.put(person, new ArrayList<String>());
        }
        ArrayList<String> friends = map.get(person);
        if (!friends.contains(newFriend)) {
            friends.add(newFriend);
        }
    }

}
