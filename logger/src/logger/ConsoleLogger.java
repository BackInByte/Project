package logger;

class ConsoleLogger implements Logger{

    public void info(String category, String message) {
        if (!category.equals("INPUT")) {
            System.out.print(message);
        }
    }


    public void error(String category, String message) {
        if (!category.equals("INPUT")) {
            System.err.print(message);
        }
    }

}
