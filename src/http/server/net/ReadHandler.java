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
        //return the channel for which the selection key was created
        SocketChannel channel = (SocketChannel) selectionKey.channel();
        //allocate buffer size with 8192 bytes
        ByteBuffer buffer = ByteBuffer.allocate(Const.DEFAULT_BUFFER_SIZE);
        int length;

        try {
            //read a sequence of bytes from channel and return the length of the bytes read
            length = channel.read(buffer);
            //set selection key permission to write
            selectionKey.interestOps(SelectionKey.OP_WRITE);

            //for receiving request from a channel 
            if (ChannelMap.isContains(selectionKey)) {
                //get the corresponding lifecycle from ChannelMap 
                LifeCycle task = ChannelMap.get(selectionKey);
                //build up a RequestWrapper from buffer
                task.newRequestWrapper(buffer, length);
                //submit a new lifecycle for processing
                LifeCycleExecution.sumbit(task);
            }

            LOG.log(Level.INFO, "Server read data from connection: " + channel.getRemoteAddress());
        } catch (IOException e) {
            LOG.log(Level.INFO, "Server handle read exception:", e);
            selectionKeyCancel();
        }
    }

}
