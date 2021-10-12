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
			repository.save(new LibraryBook("1984", "George Orwell", "1949-6-8"));
			repository.save(new LibraryBook("A Game of Thrones", "George R.R. Martin", "1996-8-1"));
			repository.save(new LibraryBook("The Cat In The Hat", "Dr. Seuss", "1957-3-12"));
			repository.save(new LibraryBook("A Clockwork Orange", "Anthony Burgess", "1962"));
			repository.save(new LibraryBook("The Invisible Man", "H.G. Wells", "1897"));
			repository.save(new LibraryBook("Fahrenheit 451", "Ray Bradbury", "1953-10-19"));
			repository.save(new LibraryBook("The Great Gatsby", "F. Scott Fitzgerald", "1925-4-10"));
			repository.save(new LibraryBook("Catch-22", "Joseph Heller", "1961-11-10"));
		};
	}
}
