package Cookies;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CalcServlet extends HttpServlet {

  private DataStorage ds;

  public CalcServlet(DataStorage ds) {
    this.ds = ds;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    int x = Integer.parseInt(req.getParameter("x"));
    int y = Integer.parseInt(req.getParameter("y"));
    int id = Integer.parseInt(req.getParameter("id"));
    ds.add(x,y,"+",x+y, id);
    resp.getWriter().println(id);
    Cookie c = new Cookie("%CALC%", String.valueOf(id));
    resp.addCookie(c);
  }
}
