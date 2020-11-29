package com.smalldot.web.login;

import com.smalldot.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping("/loginOn")
    public boolean loginOn(String userName,String password) throws Exception {
        return loginService.loginOn(userName,password);
    }
}
