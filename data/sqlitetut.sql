CREATE TABLE IF NOT EXISTS students (
  id INTEGER PRIMARY KEY,
  firstname TEXT,
  lastname TEXT,
  age INTEGER
);

CREATE TABLE IF NOT EXISTS courses (
  id INTEGER PRIMARY KEY,
  name TEXT
);

CREATE TABLE IF NOT EXISTS students_courses (
  course_id INTEGER,
  student_id INTEGER
);
