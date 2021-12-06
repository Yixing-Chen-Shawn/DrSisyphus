package http.server.net;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class BaseHandler implements Handler {
    protected static final Logger LOG = Logger.getLogger(BaseHandler.class.getName());

    protected Selector selector = null;
    protected SelectionKey selectionKey = null;

    public BaseHandler(Selector selector, SelectionKey selectionKey) {
        this.selector = selector;
        this.selectionKey = selectionKey;
    }

    protected void selectionKeyCancel() {
        selectionKey.cancel();

        try {
            selectionKey.channel().close();
        } catch (IOException e) {
            LOG.log(Level.INFO, "Serve channel close Exception:", e);
        }
    }

    @Override
    public abstract void handle();

}
