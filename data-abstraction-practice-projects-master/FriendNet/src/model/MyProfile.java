package model;

import java.util.ArrayList;
import java.util.List;

public class MyProfile {

    private String name;
    private int age;
    private String currentLocation;
    private String workPlace;
    private List<MyProfile> friendsList;
    private List<Event> upcomingEvents;

    public MyProfile(String nm, int age, String locn, String work) {
        this.name = nm;
        this.age = age;
        this.currentLocation = locn;
        this.workPlace = work;
        friendsList = new ArrayList<MyProfile>();
        upcomingEvents = new ArrayList<Event>();
    }

    // getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public int upcomingEventNum() {
        return upcomingEvents.size();
    }

    public List<MyProfile> getFriendsList() {
        return friendsList;
    }

    public List<Event> getEventList() {
        return upcomingEvents;
    }

    // REQUIRES: f is not already in friendsList
    // MODIFIES: this
    // EFFECTS: consumes a MyProfile object, a friend f, and adds it to the friendsList
    public void addFriend(MyProfile f) {
        friendsList.add(f);
    }

    // MODIFIES: this
    // EFFECTS: removes a friend with the given name from this. If removal is successful, return true, else
    //          return false
    public boolean unFriend(String nm) {
        for (int i = 0; i < friendsList.size(); i++) {
            if (friendsList.get(i).getName().equals(nm)) {
                friendsList.remove(i);
                return true;
            }
        }
        return false;
    }

    // REQUIRES: ev is not in upcomingEvents
    // MODIFIES: this
    // EFFECTS: adds the given event to the list of upcoming events
    public void addEvent(Event ev) {
        upcomingEvents.add(ev);
    }

    // MODIFIES: this
    // EFFECTS: removes an event with the given name. If removal is successful, return true, else return false
    public boolean removeEvent(String nm) {
        for (int i = 0; i < upcomingEvents.size(); i++) {
            if (upcomingEvents.get(i).getName().equals(nm)) {
                upcomingEvents.remove(i);
                return true;
            }
        }
        return false;
    }

    // EFFECTS: returns the number of events that are at the current location of this person
    public int eventNumNearMe() {
        int sum = 0;
        for (Event event : upcomingEvents) {
            if (event.getLocation().equals(currentLocation)) {
                sum++;
            }
        }
        return sum;
    }

    // EFFECTS: returns the number of events of the given type et
    public int specificEventType(EventType et) {
        int sum = 0;
        for (Event event : upcomingEvents) {
            if (event.getEventType().equals(et)) {
                sum++;
            }
        }
        return sum;
    }

    // EFFECTS: prints events of  type et to the console
    //          Hint: is there a method you have already written that you can use?
    public void printEventSchedule(EventType et) {
        for (Event event : upcomingEvents) {
            if (event.getEventType().equals(et)) {
                System.out.print(event);
            }
        }
    }

    // EFFECTS: prints out the list of friends that this MyProfile has
    public void printFriendNames() {
        System.out.println("Here is a list of your friends: ");
        for (MyProfile friend : friendsList) {
            System.out.println(friend);
        }
        System.out.println("All friends were printed.\n");
    }

    public String toString() {
        return "Name: " + name + ", age: " + age + ", location: " + currentLocation + ", job: " + workPlace;
    }

    // EFFECTS: prints out the names of friends who live at the same location associated with this profile
    public void printFriendsNearMe() {
        for (MyProfile friend : friendsList) {
            if (friend.getCurrentLocation().equals(this.getCurrentLocation())) {
                System.out.println(friend);
            }
        }
    }

    // EFFECTS: produces true if this profile has a friend with the given name,
    //          OR if any of this profile's friends has a friend with the given name
    //          Hint: use recursion!
    public boolean canFindPerson(String name) {
        if (this.friendsList.isEmpty()) {
            return false;
        }

        for (MyProfile friend : friendsList) {
            if (friend.getName().equals(name)) {
                return true;
            }
        }

        for (MyProfile friend : friendsList) {
            if(friend.canFindPerson(name)){
                return true;
            }
        }

        return false;
    }

}
