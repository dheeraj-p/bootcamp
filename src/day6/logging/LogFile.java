package day6.logging;

public class LogFile implements LoggingHandler {
    @Override
    public void log(String text) {
        System.out.println(text);
    }
}
