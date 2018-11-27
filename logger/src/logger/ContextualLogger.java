package logger;

import java.text.SimpleDateFormat;
import java.util.Date;

class ContextualLogger implements Logger {


    private Logger delegateLogger;

    public ContextualLogger(Logger delegateLogger) {
        this.delegateLogger = delegateLogger;
    }


    public void info(String category, String message) {
        SimpleDateFormat logFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss.SSS");
        delegateLogger.info(category,"Date: "+logFormat.format(new Date()) + "      categorie du message: " + category +"        level: INFO \nle message: "+message+"\n");
    }


    public void error(String category, String message) {
        SimpleDateFormat logFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss.SSS");
        delegateLogger.error(category,"Date: "+logFormat.format(new Date()) + "      categorie du message: " + category +"        level: ERROR \nle message: "+message+"\n");
    }
}