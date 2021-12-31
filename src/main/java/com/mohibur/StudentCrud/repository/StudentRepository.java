package com.mohibur.StudentCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohibur.StudentCrud.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
