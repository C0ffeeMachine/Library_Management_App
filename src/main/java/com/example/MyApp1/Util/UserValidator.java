package com.example.MyApp1.Util;

import com.example.MyApp1.DataAccessLayer.User;

public class UserValidator {

    public boolean isValid(User user){

        if(user.getName()=="" || user.getName()==null)
            return false;
        return true;
    }
}
