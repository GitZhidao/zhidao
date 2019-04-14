package com.zhidao.controller;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@Component
@WebFilter(urlPatterns = "/view/*",filterName = "LoginFilter")
public class LoginFilter implements Filter {
    private  static String login_page="/login.jsp";
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        String currentURL = request.getRequestURI();
        String ctxPath = request.getContextPath();
        String targetURL = currentURL.substring(ctxPath.length());
        HttpSession session = request.getSession(false);
        if (!("/login.jsp".equals(targetURL))&&!("/view/regist.jsp".equals(targetURL))){
            if (session==null||session.getAttribute("user")==null){
                response.sendRedirect(login_page);
            }
            else {
                chain.doFilter(request,response);
            }
        }
        else {
            chain.doFilter(request,response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
