package com.mohibur.StudentCrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohibur.StudentCrud.model.Student;
import com.mohibur.StudentCrud.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repo;

	public List<Student> listAll() {
		return repo.findAll();
	}

	public void save(Student std) {
		repo.save(std);
	}

	public Student get(int id) {
		return repo.findById(id).get();
	}

	public void delete(int id) {
		repo.deleteById(id);
	}
}
