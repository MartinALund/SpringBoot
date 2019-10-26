package dk.lundudvikling.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
@Profile("prod")
public class TestEndpoint {
    @Autowired
    private BasicConfiguration basicConfiguration;

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @Value("${welcome.message}")
    private String welcomeMessage;

    @GetMapping
    public String getTest(){
        return basicConfiguration.getMessage();
    }

    @GetMapping("profile")
    public String getActiveProfile(){
        return activeProfile;
    }

    @GetMapping("welcome")
    public String getWelcome(){
        return welcomeMessage;
    }
}
