package lesson16.web;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.StringJoiner;

public class LoginServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Map<String, String[]> parameterMap = req.getParameterMap();
    String[] xes = parameterMap.get("x");
    StringJoiner sj = new StringJoiner(":", "<", ">");
    for (String s: xes) {
      sj.add(s);
    }
    String x = req.getParameter("x");
    String pathInfo = req.getPathInfo();
    String contextPath = req.getContextPath();
    Cookie[] cookies = req.getCookies();
    Enumeration<String> headerNames = req.getHeaderNames();
    req.getHeader("dfdf");
    req.getMethod();
    String queryString = req.getQueryString();


    PrintWriter writer = resp.getWriter();
    writer.printf("LoginServlet.GET: getParameter:%s, getParameterMap:%s, pathinfo:%s, contextpath:%s, queryString:%s", x, sj.toString(), pathInfo, contextPath, queryString);
    writer.close();
  }
}
