package io.mart.jetty;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;

/**
 * @author Alexander Martyushov
 */
public class SimpleServer {

    public static void main(String[] args) throws Exception
    {
        Server server = new Server(9191);
/*
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(9191);
        server.setConnectors(new Connector[] { connector });*/

        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");
        context.addServlet(HelloServlet.class, "/hello");
        context.addServlet(AnotherServlet.class, "/echo");

        HandlerCollection handlers = new HandlerCollection();
        handlers.setHandlers(new Handler[] { context, new DefaultHandler() });
        server.setHandler(handlers);

            server.start();

        //server.join();
    }
}
