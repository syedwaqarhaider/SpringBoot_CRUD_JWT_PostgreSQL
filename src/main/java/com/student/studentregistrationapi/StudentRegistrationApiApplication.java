package com.student.studentregistrationapi;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class StudentRegistrationApiApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	public static void main(String[] args) {
		SpringApplication.run(StudentRegistrationApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String sql="INSERT INTO data(id, s_name, department) VALUES ('"+UUID.randomUUID()+"', 'Waqar', 'Computer Science')";
		int row =jdbcTemplate.update(sql);

		if (row>0)
		{
			System.out.println("Row Inserted..............");
		}
		
	}

}
