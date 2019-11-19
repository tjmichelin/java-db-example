package com.unesp.feg.esw.sqltut.model;

public class Student {
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	
	public Student() {
		this.id = 0;
		this.firstName = null;
		this.lastName = null;
		this.age = -1;
	}
	
	public Student(int id, String firstName, String lastName, int age) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public boolean equals(Object comparison) {
		boolean value = true;
		Student student = (Student)comparison;
		
		if (this.id != student.getId()) {
			value = false;
		} else if (this.firstName != student.getFirstName()) {
			value = false;
		} else if (this.lastName != student.getLastName()) {
			value = false;
		} else if (this.age != student.getAge()) {
			value = false;
		}
		
		return value;
	}

	@Override
	public String toString() {
		StringBuffer student = new StringBuffer("ID: ");
		student.append(this.id);
		student.append("\n");
		student.append("Nome: ");
		student.append(this.firstName);
		student.append(" ");
		student.append(this.lastName);
		student.append("\n");
		student.append("Age: ");
		student.append(this.age);
		student.append("\n");
		
		return student.toString();
	}
	
}
