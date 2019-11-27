package Cookies;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class HistoryServlet extends HttpServlet {
    private DataStorage ds;

    public HistoryServlet(DataStorage ds) {
        this.ds = ds;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Cookie[] cookies = req.getCookies(); // NULL
        int id = -1; // no user
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("%CALC%")) {
                    id = Integer.parseInt(c.getValue());
                }
            }
        }

        List<HistoryDataLine> byId = ds.getById(id);
        PrintWriter w = resp.getWriter();
        byId.forEach(d -> {
            w.print(d);
            w.println();
        });
        w.close();
    }
}
