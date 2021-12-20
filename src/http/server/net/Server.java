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
            //opens a selector 
            selector = Selector.open();
            //register the serverSocketChannel to a selector for accepting connections
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            LOG.log(Level.INFO, "Server listening to " + address.getAddress() + ":" + address.getPort());
        } catch (IOException e) {
            LOG.log(Level.INFO, "Init server exception:", e);
        }
    }

    //start the server 
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

            //create iterator for the key set 
            Iterator<SelectionKey> selectionKeys = selector.selectedKeys().iterator();
            Handler handler = null;

            //check if there is a next key exists 
            while (selectionKeys.hasNext()) {
                //return the selection key and then remove it.
                SelectionKey selectionKey = selectionKeys.next();
                selectionKeys.remove();

                //check if each channel's status, if its ready to accept or read or write.
                //and go to different handler for processing
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
