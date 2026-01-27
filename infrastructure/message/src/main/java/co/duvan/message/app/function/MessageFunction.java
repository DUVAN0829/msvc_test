package co.duvan.message.app.function;

import co.duvan.message.app.dto.AccountMsgDto;
import co.duvan.message.app.dto.CourseMsgDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.function.Function;

@Configuration
public class MessageFunction {

    private static final Logger log = LoggerFactory.getLogger(MessageFunction.class);

    @Bean
    public Function<CourseMsgDto, CourseMsgDto> email() {
        return courseMsgDto -> {
            log.info("Sending email with details: " + courseMsgDto.toString());
            return courseMsgDto;
        };
    }

    @Bean
    public Function<CourseMsgDto, List<Long>> sms() {
        return courseMsgDto -> {
            log.info("Sendind sms with the details: " + courseMsgDto.courseIds());
            return courseMsgDto.courseIds();
        };
    }

}
