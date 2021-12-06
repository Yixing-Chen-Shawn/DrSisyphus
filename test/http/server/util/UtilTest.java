package http.server.util;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.beans.Transient;
import java.util.Date;

import http.server.util.*;

public class UtilTest
{
    @Test
    public void getDateString() {
        Date date = new Date(System.currentTimeMillis());
        assertEquals("2021", Util.getDateString(date).substring(0, 4));
        assertEquals("12", Util.getDateString(date).substring(5, 7));
    }

    @Test
    public void int_and_bytes_convert() {
        int value = 0x12347856;
        byte[] buf = Util.toBytes(value);

        assertEquals(value, Util.toInt(buf));

        buf[0] = 0x12;
        buf[1] = 0x34;
        buf[2] = 0x78;
        buf[3] = 0x56;

        System.out.println(value + " " + Util.toInt(buf));

        assertEquals(value, Util.toInt(buf));
    }

}

