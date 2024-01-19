import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import java.nio.charset.StandardCharsets

appender("FILE", RollingFileAppender) {
    file = "./logs/mylog.log"
    rollingPolicy(TimeBasedRollingPolicy) {
        fileNamePattern = "./logs/mylog.%d{yyyyMMdd}.zip"
        maxHistory = 7
    }
    encoder(PatternLayoutEncoder) {
        charset = StandardCharsets.UTF_8
        pattern = "%d %p %t - %m%n"
    }
}

appender("STDOUT", ConsoleAppender) {
    target = "System.out"
    encoder(PatternLayoutEncoder) {
        pattern = "%d{HH:mm:ss.SSS} %p %m%n"
    }
}

root(TRACE, ["FILE", "STDOUT"])
