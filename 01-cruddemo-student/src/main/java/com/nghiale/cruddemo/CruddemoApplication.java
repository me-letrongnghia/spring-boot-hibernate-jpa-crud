package com.nghiale.cruddemo;

import com.nghiale.cruddemo.dao.StudentDAO;
import com.nghiale.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			// createStudent(studentDAO);

			// createMultipleStudent(studentDAO);

			// readStudent(studentDAO);

			// queryForStudents(studentDAO);

			// queryForStudentsByLastName(studentDAO);

			// updateStudent(studentDAO);

			// deleteStudent(studentDAO);
			
			deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {

		System.out.println("Deleting all students...");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		Scanner scanner = new Scanner(System.in);
		int select;

		// retrieve student based on the id: primary key
		System.out.print("Enter the object's ID that you want delete: ");
		int studentId = scanner.nextInt();
		System.out.println("Deleting student with ID " + studentId);
		System.out.println(studentDAO.finById(studentId));

		System.out.print("Check Student's information that you want to delete. Enter 1 to delete, 2 to cancel: ");
		select = scanner.nextInt();
		if (select == 1) {
			studentDAO.delete(studentId);
			System.out.println("Successful delete...");
		}
		else System.out.println("Successful cancel...");
	}

	private void updateStudent(StudentDAO studentDAO) {

		Scanner scanner = new Scanner(System.in);

		// retrieve student based on the id: primary key
		System.out.print("Enter the ID that you want retrieve: ");
		int studentId = scanner.nextInt();
		System.out.println("Getting student with ID " + studentId);
		Student myStudent = studentDAO.finById(studentId);

		// change first name to "Love"
		System.out.println("Updating student...");
		myStudent.setFisrtName("Love");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Le");

		// display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		// get list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating new student object...");
		Student tempStudent5 = new Student("Minh", "Dang", "nhatminh@trickerlo.com");

		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent5);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent5.getId());

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + tempStudent5.getId());

		// display student
		System.out.println("Found the student: " + studentDAO.finById(tempStudent5.getId()));
	}

	private void createMultipleStudent(StudentDAO studentDAO) {

		// create multiple students
		System.out.println("Creating 3 student objects...");
		Student tempStudent1 = new Student("To", "Le", "tole@trickerlo.com");
		Student tempStudent2 = new Student("Trung", "Nguyen", "trungnguyen@trickerlo.com");
		Student tempStudent3 = new Student("Thinh", "Tran", "thinhtran@trickerlo.com");

		// save the student objects
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Nghia", "Le", "nghiale@trickerlo.com");

		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}
