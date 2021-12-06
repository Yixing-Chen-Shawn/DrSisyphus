package http.server.main;

import java.util.logging.Level;
import java.util.logging.Logger;

import http.server.net.Server;

public class Main {
    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Server server = new Server();
        server.startup();

        LOG.log(Level.INFO, "Http Server started.");

    }
}
