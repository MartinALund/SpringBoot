package dk.lundudvikling.springdemo;

import io.micrometer.core.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("test")

public class TestEndpoint {

    Logger logger = LoggerFactory.getLogger(TestEndpoint.class);


    @Autowired
    private BasicConfiguration basicConfiguration;

    @Value("${welcome.message}")
    private String welcomeMessage;

    @GetMapping
    public String getTest(){
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
        return basicConfiguration.getMessage();
    }

    @GetMapping("welcome")
    public String getWelcome(){
        return welcomeMessage;
    }

}
