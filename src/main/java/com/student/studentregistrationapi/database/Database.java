package com.student.studentregistrationapi.database;

import com.student.studentregistrationapi.model.Account;

public interface Database {

    public boolean signup(Account newAccount);
    
}
