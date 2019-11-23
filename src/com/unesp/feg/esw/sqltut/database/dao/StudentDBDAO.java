package com.unesp.feg.esw.sqltut.database.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.unesp.feg.esw.sqltut.database.Db;
import com.unesp.feg.esw.sqltut.database.SQLiteDB;
import com.unesp.feg.esw.sqltut.model.Student;

public class StudentDBDAO implements StudentDAO {

	private Db db;
	private String dbUrl;
	
	public StudentDBDAO() throws Exception {
		this.dbUrl = "data/sqltut.db";
		this.db = new SQLiteDB(this.dbUrl);
	}
	
	@Override
	public List<Student> getAllStudents() throws Exception {
		List<Student> list = new ArrayList<Student>();
		String sql = "SELECT * FROM students";
		
		this.db.getConnection().setAutoCommit(false);
		PreparedStatement listStmt = this.db.getConnection().prepareStatement(sql);
		
		ResultSet rs = listStmt.executeQuery();
		while (rs.next()) {
			Student student = new Student();
			student.setId(rs.getInt("id"));
			student.setFirstName(rs.getString("firstname"));
			student.setLastName(rs.getString("lastname"));
			student.setAge(rs.getInt("age"));
			
			list.add(student);
		}
		this.db.getConnection().commit();
		this.db.getConnection().setAutoCommit(true);
		listStmt.close();
		return list;
	}

	@Override
	public Optional<Student> getStudentById(int id) throws Exception {
		String sql = "SELECT * FROM students WHERE id = ?";
		
		this.db.getConnection().setAutoCommit(false);
		PreparedStatement getStudent = this.db.getConnection().prepareStatement(sql);
		getStudent.setInt(1, id);
		
		ResultSet rs = getStudent.executeQuery();
		Student student = null;
		
		if (rs.next()) {
			student = new Student();
			student.setId(rs.getInt("id"));
			student.setFirstName(rs.getString("firstname"));
			student.setLastName(rs.getString("lastname"));
			student.setAge(rs.getInt("age"));
		}
		
		Optional<Student> op = Optional.ofNullable(student);		
		return op;
	}

	@Override
	public void save(Student student) throws Exception {
		String sql = "INSERT INTO students(firstname, lastname, age) VALUES(?, ?, ?)";
		
		this.db.getConnection().setAutoCommit(false);
		PreparedStatement saveStudent = this.db.getConnection().prepareStatement(sql);
		saveStudent.setString(1, student.getFirstName());
		saveStudent.setString(2, student.getLastName());
		saveStudent.setInt(3, student.getAge());
		saveStudent.execute();
		this.db.getConnection().commit();
		this.db.getConnection().setAutoCommit(true);
		saveStudent.close();
	}

	@Override
	public void delete(Student student) throws Exception {
		String sql = "DELETE FROM students WHERE students.id = ?";
		
		this.db.getConnection().setAutoCommit(false);
		PreparedStatement deleteStudent = this.db.getConnection().prepareStatement(sql);
		deleteStudent.setInt(1, student.getId());
		deleteStudent.execute();
		this.db.getConnection().commit();
		this.db.getConnection().setAutoCommit(true);
		deleteStudent.close();
	}

	@Override
	public void update(Student student) throws Exception {
		String sql = "UPDATE students SET firstname = ?, lastname = ?, age = ? WHERE id = ?";
		
		this.db.getConnection().setAutoCommit(false);
		PreparedStatement updateStudent = this.db.getConnection().prepareStatement(sql);
		updateStudent.setString(1, student.getFirstName());
		updateStudent.setString(2, student.getLastName());
		updateStudent.setInt(3, student.getAge());
		updateStudent.setInt(4, student.getId());
		
		updateStudent.execute();
		this.db.getConnection().commit();
		this.db.getConnection().setAutoCommit(true);
		updateStudent.close();
	}
	
	@Override
	protected void finalize() {
		this.db.closeConnection();
	}

}
