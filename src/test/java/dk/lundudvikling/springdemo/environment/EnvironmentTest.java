package dk.lundudvikling.springdemo.environment;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("local")
public class EnvironmentTest {
    @Value("${test}")
    private String test;

    @Value("${test.hello}")
    private String hello;

    @Test
    public void test(){
        Assert.assertEquals("local",test);
    }

    @Test
    public void testHello(){
        Assert.assertEquals("hello local",hello);
    }
}
