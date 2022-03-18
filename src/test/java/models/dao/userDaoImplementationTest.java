package models.dao;

import models.pojos.User;
import org.junit.Test;

public class userDaoImplementationTest {
    userDaoImplementation userDaoImplementation;
    User userOne = new User("Dorcas", "CEO", "lead meeting", "Executive", 1);
    User userTwo = new User("Marc", "HOD", "Department", "HR", 2);
    User userThree = new User("Jon", "Junior Developer", "IT", "IT", 3);
    @Test
    public void add() {
        userDaoImplementation.add(userOne);
        userDaoImplementation.add(userTwo);
        userDaoImplementation.add(userThree);
    }
}