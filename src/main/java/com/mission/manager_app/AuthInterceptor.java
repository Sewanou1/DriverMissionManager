package com.mission.manager_app;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String loginURI = request.getContextPath() + "/login";

        if (session.getAttribute("user") == null) {
            // L'utilisateur n'est pas connecté
            response.sendRedirect(loginURI);
            return false;
        }
        return true;
    }
}
