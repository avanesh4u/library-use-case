/**
*
* @author Avanesh Sharma
* 
*/
package com.library.demo.bean;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import com.library.demo.validation.ValidatePages;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BookRequest {

	
	private int id;
	
	@NotEmpty(message = "Code is required")
	private String code;

	@NotEmpty(message = "Title is required")
	private String title;

	@NotEmpty(message = "Author is required")
	private String author;

	@NotEmpty(message = "Publisher is required")
	private String publisher;

	@ValidatePages
	private int pages;

	@Max(value = 500, message = "Price cannot be greater than 500")
	private long price;

	private int libraryId;

}
