package someshbose.github.io.userlogin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class UserLoginApplication {

	public static void main(String[] args) {
		log.info("User application is running");
		SpringApplication.run(UserLoginApplication.class, args);
	}

}
