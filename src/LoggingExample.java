import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggingExample {
    static Logger logger = Logger.getLogger(LoggingExample.class.getName());

    public static void main(String[] args) {
        try {
            LogManager.getLogManager().readConfiguration(new FileInputStream("mylogging.properties"));
        } catch (SecurityException|IOException e) {
            e.printStackTrace();
        }
        logger.setLevel(Level.FINE);
        logger.addHandler(new ConsoleHandler());

        //adding custom handler
        logger.addHandler(new MyHandler());
        try {
            Handler fileHandler = new FileHandler("/Users/irynasavchuk/Desktop/TESI/code/Java_Logger_Example/JavaLoggingExample/src/tmp/logger.log",2000,5);
            fileHandler.setFormatter(new MyFormatter());
            fileHandler.setFilter(new MyFilter());
            logger.addHandler(fileHandler);

            for (int i = 0; i < 1000; i++) {
                logger.log(Level.INFO, "Msg "+i);
            }

            logger.log(Level.CONFIG, "Config data");
        } catch (SecurityException|IOException e) {
             e.printStackTrace();
        }
    }
}
