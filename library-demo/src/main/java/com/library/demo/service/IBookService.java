/**
*
* @author Avanesh Sharma
* 
*/
package com.library.demo.service;

import java.util.List;

import com.library.demo.bean.BookRequest;
import com.library.demo.model.Book;

public interface IBookService {

	public void addBook(BookRequest bookRequest);

	public List<Book> getBooks(int libraryId);

	public void deleteBook(int bookId);

	public Book getBookById(int bookId);
	
	public void updateBook(BookRequest bookRequest);

}
