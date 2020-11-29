package com.smalldot.service.login.impl;

import com.smalldot.service.login.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public boolean loginOn(String userName, String password) throws Exception {
        return false;
    }
}
