package http.server.util;

import java.util.Date;
import java.util.Locale;
import java.text.*;

public class Util {
    // private static final Logger LOG = Logger.getLogger(Util.class.getName());

    private Util() {
    }

    public static String getDateString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    public static String getGMTString(Date date)
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        return simpleDateFormat.format(date);
    }

    public static byte[] toBytes(int value) {
        byte[] buf = new byte[4];

        // int -> bytes
        buf[0] = (byte) ((value & 0xFF000000) >> 24);
        buf[1] = (byte) ((value & 0x00FF0000) >> 16);
        buf[2] = (byte) ((value & 0x0000FF00) >> 8);
        buf[3] = (byte) (value & 0x000000FF);

        return buf;
    }

    public static int toInt(byte[] buf) {
        int value = 0;

        value |= buf[0] << 24;
        value |= buf[1] << 16;
        value |= buf[2] << 8;
        value |= buf[3];

        return value;
    }
}