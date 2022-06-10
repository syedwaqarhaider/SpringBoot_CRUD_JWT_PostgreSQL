package com.student.studentregistrationapi.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.student.studentregistrationapi.Constants;
import com.student.studentregistrationapi.database.Database;
import com.student.studentregistrationapi.model.Account;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Service
public class StudentService {
    
    private Database database;
    @Autowired
    public StudentService(@Qualifier("MyData") Database database) {
        this.database = database;
    }

    public Map<String, String> createNewAccont(Account newAccount)
    {
        Map<String, String> map=new HashMap<>();
        if(this.database.signup(newAccount))
        {
            
            map.put("token", generateToken(newAccount));
        }
        else{
            
           
              map.put("Error", "Database Error");
        
        }
        return map;
    }


    public String generateToken(Account newAccount)
    {
        long timestamp= System.currentTimeMillis();
        
       String token=Jwts.builder().signWith(SignatureAlgorithm.HS256, Constants.API_SECRET_KEY)
       .setIssuedAt(new Date(timestamp))
       .setExpiration(new Date(timestamp+Constants.EXPIRY_TIME))
       .claim("username", newAccount.getUsername())
       .compact();

        return token;
    }
    

}
