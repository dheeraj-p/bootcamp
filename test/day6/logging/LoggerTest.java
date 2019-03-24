package day6.logging;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class LoggerTest {

    @Test
    void shouldLogGivenTextWithProvidedHandler() {
    LoggingHandler fileLogger = text -> assertEquals("Something", text);

        Logger logger = new Logger(fileLogger);
        logger.log("Something");
    }
}