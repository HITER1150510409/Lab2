package com.ANT.Library.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter(filterName = "AdminLoginFilter",urlPatterns = {"/pages/index.jsp","/pages/back/item/*","/pages/back/member/*"})
public class AdminLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession(); // ȡ��session�ӿڶ���
        if (session.getAttribute("aid") != null){ // ��ʾ�����ݴ���
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            request.setAttribute("msg","�㻹δ��¼�����ȵ�¼�����!");
            request.setAttribute("url","/login.jsp");
            request.getRequestDispatcher("/pages/forward.jsp").forward(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
