/**
*
* @author Avanesh Sharma
* 
*/
package com.library.demo.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.library.demo.model.Library;
import com.library.demo.service.ILibraryService;

@RestController
@RequestMapping("/library")
@CrossOrigin(origins = "http://localhost:4200")
public class LibraryController {

	@Autowired
	ILibraryService libraryService;

	@GetMapping(value = "/getLibraries", produces = "application/json")
	public ResponseEntity<List<Library>> getLibraries() {
		List<Library> libraryList = new ArrayList<>();
		libraryList = libraryService.getLibraries();
		return new ResponseEntity<>(libraryList, HttpStatus.OK);
	}

}
