package com.nadhem.users.exceptions;

import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {

        // Check if the exception is due to a disabled user
        if (exception instanceof DisabledException) {
           System.out.println("dissssssssssssssssssssssssssssssssssssssssssabed");
            
           response.getWriter().print("user disabled");
        	//response.sendRedirect("/account-disabled"); // Redirect to a custom page
        } else {
            // Handle other authentication failures
            response.sendRedirect("/login?error"); // Redirect to the login page with an error parameter
        }
    }
}
