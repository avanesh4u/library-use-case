/**
*
* @author Avanesh Sharma
* 
*/
package com.library.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.library.demo.bean.BookRequest;
import com.library.demo.exception.ErrorResponse;
import com.library.demo.exception.LibraryException;
import com.library.demo.model.Book;
import com.library.demo.service.IBookService;

@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {
	
	private static final Logger logger = LogManager.getLogger(BookController.class);

	@Autowired
	private IBookService bookService;

	@GetMapping(value = "/getBooks/{libraryId}", produces = "application/json")
	public ResponseEntity<?> getBooks(@PathVariable(value = "libraryId") int libraryId) {
		List<Book> bookList = new ArrayList<>();
		bookList = bookService.getBooks(libraryId);		
		return new ResponseEntity<>(bookList, HttpStatus.OK);
	}

	@GetMapping(value = "/getBook/{id}", produces = "application/json")
	public ResponseEntity<?> getBook(@PathVariable(value = "id") int bookId) {
		Book book = bookService.getBookById(bookId);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}

	@PostMapping(value = "/add", produces = "application/json")
	public ResponseEntity<?> addBook(@RequestBody @Valid BookRequest bookRequest) {
		try {
			bookService.addBook(bookRequest);
		} catch (LibraryException libraryException) {
			logger.error("Exception occurs while saving Book : {}", libraryException.getMessage());
			List<ErrorResponse> errors = new ArrayList<>();
			errors.add(new ErrorResponse(libraryException.getCode(), libraryException.getMessage()));
			Map<String, Object> body = new LinkedHashMap<>();
			body.put("errors", errors);
			return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
		}

		Map<String, String> successResponse = new HashMap<>();
		successResponse.put("status", "OK");
		return new ResponseEntity<>(successResponse, HttpStatus.OK);
	}

	@PutMapping(value = "/update", produces = "application/json")
	public ResponseEntity<?> updateBook(@RequestBody BookRequest bookRequest) {
		bookService.updateBook(bookRequest);
		Map<String, String> successResponse = new HashMap<>();
		successResponse.put("status", "OK");
		return new ResponseEntity<>(successResponse, HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{id}", produces = "application/json")
	public ResponseEntity<?>  deleteBook(@PathVariable(value = "id") int bookId) {
		bookService.deleteBook(bookId);
		Map<String, String> successResponse = new HashMap<>();
		successResponse.put("status", "OK");
		return new ResponseEntity<>(successResponse, HttpStatus.OK);
	}
}
