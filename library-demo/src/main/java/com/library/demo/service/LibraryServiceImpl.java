/**
*
* @author Avanesh Sharma
* 
*/
package com.library.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.demo.model.Library;
import com.library.demo.repository.LibraryRepository;

@Service
public class LibraryServiceImpl implements ILibraryService {

	@Autowired
	private LibraryRepository libraryRepository;
	
	@Override
	public List<Library> getLibraries() {
		List<Library> libraries = new ArrayList<>();
		 libraryRepository.findAll().forEach(library -> libraries.add(library));
		 return libraries;
	}

}
