/**
*
* @author Avanesh Sharma
* 
*/
package com.library.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.library.demo.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

	@Query("from Book b where library_id = :id")
	List<Book> findBookByLibrariId(@Param("id") int id);
}
