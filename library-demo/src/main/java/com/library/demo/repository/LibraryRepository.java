/**
*
* @author Avanesh Sharma
* 
*/
package com.library.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.library.demo.model.Library;
@Repository
public interface LibraryRepository extends CrudRepository<Library, Integer> {

}
