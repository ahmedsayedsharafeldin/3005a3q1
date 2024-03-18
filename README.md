# 3005a3q1
youtube video https://youtu.be/kEBkw4s4ldU

 connect to pg admin and update the inforemation of the url and password in the code.
 create a database and make students table using:
 CREATE TABLE students (
    student_id SERIAL PRIMARY KEY,
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    email TEXT NOT NULL UNIQUE,
    enrollment_date DATE
);
 and populate it using:
 INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES
('John', 'Doe', 'john.doe@example.com', '2023-09-01'),
('Jane', 'Smith', 'jane.smith@example.com', '2023-09-01'),
('Jim', 'Beam', 'jim.beam@example.com', '2023-09-02')

then run code by changing the functions in the main function to what every you want (there are some test already in there for ease of use)
