package day6.logging;

public class Logger {

    private final LoggingHandler handler;

    Logger(LoggingHandler handler) {
        this.handler = handler;
    }

    void log(String text) {
        handler.log(text);
    }
}
