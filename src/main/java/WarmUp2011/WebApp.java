package WarmUp2011;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class WebApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler handler = new ServletContextHandler();

        handler.addServlet(ServletFile.class, "/static/*");
        handler.addServlet(ServletRedirect.class, "/static/*");

        server.setHandler(handler);
        server.start();
        server.join();
    }
}
