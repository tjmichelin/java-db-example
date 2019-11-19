package com.unesp.feg.esw.sqltut.database.dao;

import java.util.List;
import java.util.Optional;

import com.unesp.feg.esw.sqltut.model.Student;

public interface StudentDAO {
	public List<Student> getAllStudents() throws Exception;
	public Optional<Student> getStudentById(int id) throws Exception;
	public void save(Student student) throws Exception;
	public void delete(Student student) throws Exception;
	public void update(Student student) throws Exception;
}
