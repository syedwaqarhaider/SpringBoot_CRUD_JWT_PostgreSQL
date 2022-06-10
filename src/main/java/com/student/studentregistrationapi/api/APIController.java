package com.student.studentregistrationapi.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.studentregistrationapi.model.Account;
import com.student.studentregistrationapi.service.StudentService;
@RequestMapping("/api/account")
@RestController
public class APIController {
    
    private StudentService studentService;
     @Autowired
    public APIController(StudentService studentService) {
        this.studentService = studentService;
    }

    //EndPoint
    @PostMapping
    public Map<String, String> createNewAccount(@RequestBody Account newAccount)
    {
        System.out.println("Create Account Woring.......");
        return this.studentService.createNewAccont(newAccount);
    }
    
}
