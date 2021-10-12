package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.LibraryBook;
import net.javaguides.springboot.service.LibraryBookService;

@RestController
public class LibraryBookController {
	
	@Autowired
	private LibraryBookService bookService;
	
	//add a new book to library database
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/addBook")
	public ResponseEntity<LibraryBook> addBook(@RequestBody LibraryBook book) {
		return ResponseEntity.ok().body(this.bookService.addBook(book));
	}
	
	//get all books from library database
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/getBooks")
	public ResponseEntity<List<LibraryBook>> getAllBooks() {
		return ResponseEntity.ok().body(this.bookService.getAllBooks());
	}
	
	//get only books with matching titles
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/getBooksTitle/{title}")
	public ResponseEntity<List<LibraryBook>> getBooksByTitle(@PathVariable String title) {
		System.out.println("Title: " + title);
		return ResponseEntity.ok().body(this.bookService.getBooksByTitle(title));
	}
	
	//get only books with matching authors
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/getBooksAuthor/{author}")
	public ResponseEntity<List<LibraryBook>> getBooksByAuthor(@PathVariable String author) {
		System.out.println("Author: " + author);
		System.out.println(this.bookService.getBooksByAuthor(author));
		return ResponseEntity.ok().body(this.bookService.getBooksByAuthor(author));
	}
}
