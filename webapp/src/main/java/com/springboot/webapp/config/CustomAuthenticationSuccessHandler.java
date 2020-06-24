package com.springboot.webapp.config;

import com.springboot.webapp.entity.Role;
import com.springboot.webapp.entity.User;
import com.springboot.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userService;

    @Autowired
    private ActiveUser activeUser;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println("\n\nIn customAuthenticationSuccessHandler\n\n");

        int userId = Integer.parseInt(authentication.getName());

        System.out.println("userId=" + userId);

        User theUser = userService.findById(userId);
        List<Role> roles = theUser.getRoles();

        // now place in the session
        HttpSession session = request.getSession(false);
        if(session != null) {
            LoggedUser user = new LoggedUser(authentication.getName(),roles,activeUser);
            session.setAttribute("user", user);
        }

        System.out.println(session.getAttribute("user").toString());

        // forward to home page
        response.sendRedirect(request.getContextPath() + "/home");
    }
}