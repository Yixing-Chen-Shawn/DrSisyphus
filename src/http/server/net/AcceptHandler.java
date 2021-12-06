package http.server.net;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.logging.Level;

import http.server.task.LifeCycle;

public class AcceptHandler extends BaseHandler {

    public AcceptHandler(Selector selector, SelectionKey selectionKey) {
        super(selector, selectionKey);
    }

    @Override
    public void handle() {
        ServerSocketChannel serverChannel = (ServerSocketChannel) selectionKey.channel();

        try {
            SocketChannel channel = serverChannel.accept();
            channel.configureBlocking(false);
            selectionKey = channel.register(selector, SelectionKey.OP_READ);

            ChannelMap.put(selectionKey, new LifeCycle());
            LOG.log(Level.INFO, "Server accept new connection: " + channel.getRemoteAddress());
        } catch (IOException e) {
            LOG.log(Level.INFO, "Server handle accept exception:", e);
            selectionKeyCancel();
        }

    }

}
