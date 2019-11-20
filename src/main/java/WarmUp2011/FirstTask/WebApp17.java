package WarmUp2011.FirstTask;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class WebApp17 {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8082);
        ServletContextHandler handler = new ServletContextHandler();

        handler.addServlet(HelloNameServlet.class, "/hello/*");
        handler.addServlet(ByeNameServlet.class, "/bye/*");

        server.setHandler(handler);
        server.start();
        server.join();
    }
}
