package dk.lundudvikling.springdemo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("basic")
public class BasicConfiguration {
    private boolean value;
    private String message;
    private int number;

    public void setValue(boolean value) {
        this.value = value;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }

    public int getNumber() {
        return number;
    }
}
