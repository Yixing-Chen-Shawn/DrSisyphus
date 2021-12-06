package http.server.net;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.logging.Level;

import http.server.bean.Const;
import http.server.task.LifeCycle;
import http.server.task.LifeCycleExecution;

public class ReadHandler extends BaseHandler {

    public ReadHandler(Selector selector, SelectionKey selectionKey) {
        super(selector, selectionKey);
    }

    @Override
    public void handle() {
        SocketChannel channel = (SocketChannel) selectionKey.channel();
        ByteBuffer buffer = ByteBuffer.allocate(Const.DEFAULT_BUFFER_SIZE);
        int length;

        try {
            length = channel.read(buffer);
            selectionKey.interestOps(SelectionKey.OP_WRITE);

            if (ChannelMap.isContains(selectionKey)) {
                LifeCycle task = ChannelMap.get(selectionKey);
                task.newRequestWrapper(buffer, length);
                LifeCycleExecution.sumbit(task);
            }

            LOG.log(Level.INFO, "Server read data from connection: " + channel.getRemoteAddress());
        } catch (IOException e) {
            LOG.log(Level.INFO, "Server handle read exception:", e);
            selectionKeyCancel();
        }
    }

}
