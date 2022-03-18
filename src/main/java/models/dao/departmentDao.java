package models.dao;

import models.pojos.Department;

import java.util.List;

public interface departmentDao {
    //post
    void add(Department department);

    //get
    List<Department> getAllDeparts();

    //get by id
    Department findById(int id);
}
