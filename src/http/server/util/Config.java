package http.server.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import http.server.bean.*;

public class Config {
    private static final Logger LOG = Logger.getLogger(Config.class.getName());

    private Config() {
    }

    public static String getProperty(String key) {
        Properties properties = new Properties();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(Const.CONFIG_FILE);
            bufferedReader = new BufferedReader(fileReader);
            properties.load(bufferedReader);
            fileReader.close();
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            LOG.log(Level.WARNING, "Exception: ", e);
        } catch (IOException e) {
            LOG.log(Level.WARNING, "Exception: ", e);
        }

        return properties.getProperty(key);
    }

}
