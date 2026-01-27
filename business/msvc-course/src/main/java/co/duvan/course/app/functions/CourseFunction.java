package co.duvan.course.app.functions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.function.Consumer;

@Configuration
public class CourseFunction {

    private static final Logger log = LoggerFactory.getLogger(CourseFunction.class);

    @Bean
    public Consumer<List<Long>> updateCommunication() {
        return accountNumber -> log.info("Updating Communication status for the account number: " + accountNumber.toString());
    }

}
