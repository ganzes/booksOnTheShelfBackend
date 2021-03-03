package booksontheshelfbackend;

import booksontheshelfbackend.entities.UploadFile;
import booksontheshelfbackend.repositories.UploadRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(UploadFile.class)
public class BooksOnTheShelfBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksOnTheShelfBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UploadRepository uploadRepository) {
		return (args) -> {
			uploadRepository.deleteAll();
			uploadRepository.init();
		};
	}
}
