package dk.lundudvikling.springdemo;

import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
@Timed
public class TestEndpoint {

    @Autowired
    private BasicConfiguration basicConfiguration;

    @Value("${welcome.message}")
    private String welcomeMessage;

    @GetMapping
    public String getTest(){
        return basicConfiguration.getMessage();
    }

    @GetMapping("welcome")
    public String getWelcome(){
        return welcomeMessage;
    }

}
