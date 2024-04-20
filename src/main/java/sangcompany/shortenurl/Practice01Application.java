package sangcompany.shortenurl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class Practice01Application {

	public static void main(String[] args) {
		SpringApplication.run(Practice01Application.class, args);
	}

}
