package dk.lundudvikling.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
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

    @GetMapping("http")
    public String getRest(){
        HttpService service = new HttpService();
        return service.getJsonDataFromUrl("https://httpbin.org/get");
    }
}
