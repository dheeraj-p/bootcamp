package day6.logging;

public class Console implements LoggingHandler {
    @Override
    public void log(String text) {
        System.out.println(text);
    }
}
