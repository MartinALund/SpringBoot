package dk.lundudvikling.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@SpringBootApplication
public class SpringdemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringdemoApplication.class, args);
	}

}
