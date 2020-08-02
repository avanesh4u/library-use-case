/**
*
* @author Avanesh Sharma
* 
*/
package com.library.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Book")
public class Book implements Serializable {

	private static final long serialVersionUID = 7316194790924243354L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "isbn_code")
	private String code;
	@Column(name = "title")
	private String title;

	@Column(name = "author")
	private String author;
	@Column(name = "publisher")
	private String publisher;
	@Column(name = "pages")
	private int pages;
	@Column(name = "price")
	private long price;	
	@ManyToOne
	@JoinColumn(name = "library_id", nullable = false)
	private Library library;

}
