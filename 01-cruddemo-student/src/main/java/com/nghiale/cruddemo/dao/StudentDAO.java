package com.nghiale.cruddemo.dao;

import com.nghiale.cruddemo.entity.Student;
import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student finById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();
}
