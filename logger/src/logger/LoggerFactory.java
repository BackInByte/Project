package logger;

public class LoggerFactory {

    public static Logger getLogger(String name) {
        return new CompositeLogger(new ContextualLogger(new FileLogger("./loggerOutput.txt")),  new ConsoleLogger());
    }

}