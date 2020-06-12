package dk.lundudvikling.springdemo.environment;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("staging")
public class EnvironmentLocalTest {
    @Value("${test}")
    private String test;

    @Value("${test.hello}")
    private String hello;

    @Autowired
    private Environment environment;

    @Test
    public void test(){
        System.out.println("PROFILE: " + environment.getActiveProfiles()[0]);
        Assert.assertEquals("local",test);
    }

    @Test
    public void testHello(){
        Assert.assertEquals("hello local",hello);
    }
}
