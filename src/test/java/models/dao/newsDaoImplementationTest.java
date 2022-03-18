package models.dao;

import models.pojos.News;
import org.junit.Test;

public class newsDaoImplementationTest {

    newsDaoImplementation newsDaoImplementation;
    News newsOne = new News("Best Candidate", "Interviews", 1);
    News newsTwo = new News("Meta", "Revolution of FB", 2);
    News newsThree = new News("Social influence", "Coca cola strategy", 3);

    @Test
    public void add() {
        newsDaoImplementation.add(newsOne);
        newsDaoImplementation.add(newsTwo);
        newsDaoImplementation.add(newsThree);
    }

    @Test
    public void getAllNews() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void findNewsByDepart() {
    }
}