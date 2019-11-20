package Template_Engine;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class TemplateWeb {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8082);
        ServletContextHandler handler = new ServletContextHandler();
        TemplateEngine te = new TemplateEngine("./content/templates");
        handler.addServlet(new ServletHolder(new TemplateServlet(te)), "/te/*");

        server.setHandler(handler);
        server.start();
        server.join();
    }
}
