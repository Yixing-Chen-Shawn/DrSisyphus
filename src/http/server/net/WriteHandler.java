package http.server.net;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.logging.Level;

import http.server.bean.ChannelStatus;
import http.server.task.LifeCycle;

public class WriteHandler extends BaseHandler {

    public WriteHandler(Selector selector, SelectionKey selectionKey) {
        super(selector, selectionKey);
    }

    @Override
    public void handle() {
        //return the channel for which the selection key was created, and cast to SocketChannel
        SocketChannel channel = (SocketChannel) selectionKey.channel();
        //get corresponding lifecycle object with selectionkey
        LifeCycle lifeCycle = ChannelMap.get(selectionKey);

        try {
            //check connection status in each lifecycle
            switch (lifeCycle.getConnectionStatus()) {
                case Close_Connect:
                    closeConnect(channel);
                    break;

                case Write_Data:
                    writeData(channel, lifeCycle);
                    break;

                default:
                    break;
            }

        } catch (IOException e) {
            LOG.log(Level.INFO, "Server handle write exception:", e);
            selectionKeyCancel();
        }
    }

    private void closeConnect(SocketChannel channel) throws IOException {
        LOG.log(Level.INFO, "Server close connection:" + channel.getRemoteAddress());
        ChannelMap.remove(selectionKey);
        channel.close();
    }

    private void writeData(SocketChannel channel, LifeCycle lifeCycle) throws IOException {
        ByteBuffer buffer;
        int len;

        buffer = lifeCycle.getResponseHeader();

        if (null != buffer && buffer.hasRemaining()) {
            len = channel.write(buffer);

            LOG.log(Level.INFO,
                    "Server write response header to connection: len=" + len + ", buffer=" + buffer);
        }

        buffer = lifeCycle.getResponseContent();

        if (null != buffer && buffer.hasRemaining()) {
            len = channel.write(buffer);
            LOG.log(Level.INFO,
                    "Server write response content to connection: len=" + len + ", buffer=" + buffer);
        }

        LOG.log(Level.INFO, "Server write data to connection: " + channel.getRemoteAddress());
        
        lifeCycle.setChannelStatus(ChannelStatus.Close_Connect);
    }

}
