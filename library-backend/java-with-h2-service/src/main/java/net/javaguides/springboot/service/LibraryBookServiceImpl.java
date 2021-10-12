package net.javaguides.springboot.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springboot.model.LibraryBook;
import net.javaguides.springboot.repository.LibraryBookRepository;

@Service
@Transactional
public class LibraryBookServiceImpl implements LibraryBookService {
	@Autowired
	private LibraryBookRepository libraryBookRepository;
	
	@Override
	public LibraryBook addBook(LibraryBook book) {
		return libraryBookRepository.save(book);
	}
	
	@Override
	public List<LibraryBook> getAllBooks() {
		return this.libraryBookRepository.findAll();
	}
	
	@Override
	public List<LibraryBook> getBooksByTitle(String title) {
		//use example to search books that contain the title string provided
		//resource used: https://www.baeldung.com/spring-data-query-by-example
//		ExampleMatcher caseInsensitive = ExampleMatcher.matchingAll().withIgnoreCase();
//		LibraryBook exampleBook = new LibraryBook(title, null, null);
//		exampleBook.setTitle(title);
//		Example<LibraryBook> example = Example.of(exampleBook, caseInsensitive);
//		return this.libraryBookRepository.findAll(example);
		
		//get all books from query, and return list with only those that have the same title
		//probably faster to use a proper query to filter results instead of returning all, but I was unable to get Examples to work
		List<LibraryBook> results = this.libraryBookRepository.findAll();
		List<LibraryBook> toReturn = new ArrayList<LibraryBook>(); //empty list
		for (LibraryBook book : results)
		{
			//ignore case, check if string contains the other
			if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
				toReturn.add(book);
			}
		}
		return toReturn;
	}
	
	@Override
	public List<LibraryBook> getBooksByAuthor(String author) {
		//use example to search books that contain the author string provided
		//resource used: https://www.baeldung.com/spring-data-query-by-example
//		ExampleMatcher caseInsensitive = ExampleMatcher.matchingAll().withIgnoreCase();
//		LibraryBook exampleBook = new LibraryBook(null, author, null);
//		exampleBook.setAuthor(author);
//		Example<LibraryBook> example = Example.of(exampleBook, caseInsensitive);
//		System.out.println("Example:" + example);
//		return this.libraryBookRepository.findAll(example);
		
		//get all books from query, and return list with only those that have the same author
		//probably faster to use a proper query to filter results instead of returning all, but I was unable to get Examples to work
		List<LibraryBook> results = this.libraryBookRepository.findAll();
		List<LibraryBook> toReturn = new ArrayList<LibraryBook>(); //empty list
		for (LibraryBook book : results)
		{
			//ignore case, check if string contains the other
			if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
				toReturn.add(book);
			}
		}
		return toReturn;
	}
	
	
	
}
