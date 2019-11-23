package com.unesp.feg.esw.sqltut;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.unesp.feg.esw.sqltut.database.dao.StudentDAO;
import com.unesp.feg.esw.sqltut.database.dao.StudentDBDAO;
import com.unesp.feg.esw.sqltut.model.Student;

public class SQLiteTut {

	public static void main(String[] args) {
		StudentDAO dao;
		
		try {
			dao = new StudentDBDAO();
			
			Optional<Student> op = dao.getStudentById(1);
			if (op.isPresent()) {
				System.out.println(op.get().toString());
			} else {
				System.out.println("Couldn't find any student with this ID");
			}
			
			List<Student> list = dao.getAllStudents();
			
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).toString());
			}
		} catch (ClassNotFoundException enf) {
			System.out.println(enf.getMessage());
		} catch (SQLException esql) {
			System.out.println(esql.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
