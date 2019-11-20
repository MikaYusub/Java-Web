package Auth;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class WebAppAuth {
  public static void main(String[] args) throws Exception {
    Server server = new Server(8082);
    ServletContextHandler handler = new ServletContextHandler();
/*
 * http://localhost:8082/static/img/total.png
 * http://localhost:8082/static/index.html
 * /static/img/total.png
 */
    handler.addServlet(ServletFile.class, "/static/*");
    handler.addServlet(LoginServlet.class, "/login/*");

    handler.addServlet(new ServletHolder(new ServletRedirect("/extra2/*")), "/extra/*");
    handler.addServlet(new ServletHolder(new ServletRedirect("/login")), "/*");

    server.setHandler(handler);
    server.start();
    server.join();
  }
}
