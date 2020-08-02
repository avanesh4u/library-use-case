/**
*
* @author Avanesh Sharma
* 
*/
package com.library.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.demo.bean.BookRequest;
import com.library.demo.constants.LibraryConstants;
import com.library.demo.constants.ResponseCode;
import com.library.demo.exception.LibraryException;
import com.library.demo.model.Book;
import com.library.demo.model.Library;
import com.library.demo.repository.BookRepository;
import lombok.NonNull;

@Service
public class BookServiceImpl implements IBookService {

	private static final Logger logger = LogManager.getLogger(BookServiceImpl.class);

	@Autowired
	private BookRepository bookRepository;

	@Override
	public void addBook(@NonNull BookRequest bookRequest) throws LibraryException {
		logger.info("Adding book to library");
		try {
			if (!validateInput(bookRequest)) {
				throw new LibraryException(String.valueOf(ResponseCode.INVALID_INPUT_CODE),
						LibraryConstants.INVALID_INPUT);
			}

			Book book = requestMapping(bookRequest);
			bookRepository.save(book);

		} catch (LibraryException libraryException) {
			logger.error("Exception while adding book {} to library {}  ", libraryException.getMessage(),
					bookRequest.getLibraryId());
			throw libraryException;
		}
	}

	/**
	 * @param bookRequest
	 * @return
	 */
	private Book requestMapping(@NonNull BookRequest bookRequest) {
		Book book = new Book();
		book.setId(bookRequest.getId());
		book.setCode(bookRequest.getCode());
		book.setAuthor(bookRequest.getAuthor());
		book.setTitle(bookRequest.getTitle());
		book.setPages(bookRequest.getPages());
		book.setPrice(bookRequest.getPrice());
		book.setPublisher(bookRequest.getPublisher());

		Library library = new Library();
		library.setId(bookRequest.getLibraryId());

		book.setLibrary(library);

		return book;
	}

	private boolean validateInput(BookRequest bookRequest) {
		if (bookRequest.getPrice() > 500) {
			throw new LibraryException(String.valueOf(ResponseCode.INVALID_BOOK_PRICE_CODE),
					LibraryConstants.INVALID_BOOK_PRICE);
		}
		return true;
	}

	@Override
	public List<Book> getBooks(int libraryId) {
		List<Book> books = new ArrayList<>();
		bookRepository.findBookByLibrariId(libraryId).forEach(book -> books.add(book));
		return books;
	}

	@Override
	public void deleteBook(int bookId) {
		bookRepository.deleteById(bookId);
	}
	
	@Override
	public void updateBook(BookRequest bookRequest) {	
		Book book = requestMapping(bookRequest);
		bookRepository.save(book);
	}

	@Override
	public Book getBookById(int bookId) {
		return bookRepository.findById(bookId).get();
	}

}
