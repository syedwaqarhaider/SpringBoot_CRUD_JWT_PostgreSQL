package com.student.studentregistrationapi.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.student.studentregistrationapi.model.Account;
@Repository("MyData")
public class Dao implements Database {
    @Autowired
	private JdbcTemplate jdbcTemplate;
    @Override
    public boolean signup(Account newAccount) {
        System.out.println("Running............");
        String sql="INSERT INTO accounts(username, password) VALUES('"+newAccount.getUsername()+"','"+newAccount.getPassword()+"')";
		int row =jdbcTemplate.update(sql);

		if (row>0)
		{
			return true; 
		}
        else{
            return false;
        }
      
    }
    
}
