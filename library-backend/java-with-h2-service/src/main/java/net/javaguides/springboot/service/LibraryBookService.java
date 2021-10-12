package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.LibraryBook;

public interface LibraryBookService {
	public LibraryBook addBook(LibraryBook book);
	public List<LibraryBook> getAllBooks();
	
	public List<LibraryBook> getBooksByTitle(String title);
	public List<LibraryBook> getBooksByAuthor(String Author);
	
}
