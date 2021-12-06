package http.server.net;

import java.nio.channels.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import http.server.bean.Const;

import java.io.*;

public class Server extends Thread {
    private static final Logger LOG = Logger.getLogger(Server.class.getName());

    private boolean isRunning = true;
    private Selector selector = null;

    public void init() {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            ServerSocket serverSocket = serverSocketChannel.socket();

            InetSocketAddress address = new InetSocketAddress(Const.HTTP_DEFAULT_PORT);
            serverSocket.bind(address);
            serverSocketChannel.configureBlocking(false);
            selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            LOG.log(Level.INFO, "Server listening to " + address.getAddress() + ":" + address.getPort());
        } catch (IOException e) {
            LOG.log(Level.INFO, "Init server exception:", e);
        }
    }

    public void startup() {
        init();
        start();
    }

    public void shutdown() {
        this.isRunning = false;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                selector.select();
            } catch (IOException e) {
                LOG.log(Level.INFO, "Server run exception:", e);
            }

            Iterator<SelectionKey> selectionKeys = selector.selectedKeys().iterator();
            Handler handler = null;

            while (selectionKeys.hasNext()) {
                SelectionKey selectionKey = selectionKeys.next();
                selectionKeys.remove();

                if (selectionKey.isAcceptable()) {
                    handler = new AcceptHandler(selector, selectionKey);
                } else if (selectionKey.isReadable()) {
                    handler = new ReadHandler(selector, selectionKey);
                } else if (selectionKey.isWritable()) {
                    handler = new WriteHandler(selector, selectionKey);
                }

                handler.handle();
            }
        }
    }

}
