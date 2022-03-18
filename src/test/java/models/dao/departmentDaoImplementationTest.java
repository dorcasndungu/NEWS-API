package models.dao;

import models.pojos.Department;
import org.junit.Test;

public class departmentDaoImplementationTest {
    departmentDaoImplementation departmentDaoImplementation ;

    Department firstDepart = new Department("HR", "Employment", 1);
    Department secondDepart = new Department("cyberSecurity", "Data protection", 2);
    Department thirdDepart = new Department("marketing", "Market startup", 3);

    @Test
    public void add() {
        departmentDaoImplementation.add(firstDepart);
        departmentDaoImplementation.add(secondDepart);
        departmentDaoImplementation.add(thirdDepart);
    }

    @Test
    public void getAllDeparts() {
    }

    @Test
    public void findById() {
    }
}