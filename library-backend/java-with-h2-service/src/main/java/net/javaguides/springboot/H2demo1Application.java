//tutorial used: https://youtu.be/Koe7oC1Sq0c
package net.javaguides.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import net.javaguides.springboot.model.LibraryBook;
import net.javaguides.springboot.repository.LibraryBookRepository;

@SpringBootApplication
public class H2demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(H2demo1Application.class, args);
	}

	//add a few books on startup
	//reference: https://www.youtube.com/watch?v=tSJW5NKPhcM @ 6 minutes
	@Bean
	CommandLineRunner runner(LibraryBookRepository repository) {
		return args -> {
			repository.save(new LibraryBook("Book1", "Author1", "Date1"));
			repository.save(new LibraryBook("Book2", "Author2", "Date2"));
			repository.save(new LibraryBook("Book3", "Author2", "Date3"));
		};
	}
}
