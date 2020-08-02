import { Component, OnInit } from '@angular/core';

import { Book } from '../model/Book';
import { BookService } from '../book.service';
import {Router} from "@angular/router";

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  books: Book[] =[
    {
      "id": 0,
      "code": "123",
      "title": "Core Java",
      "author": "ABC",
      "publisher": "Head first",
      "pages": 100,
      "price": 120,
       "library": { "id": 1, discription: '', location: '', name:''}
      }
  ];
  constructor(private router: Router, public bookService: BookService) { }

  ngOnInit(): void {
      let libraryId = window.localStorage.getItem("libraryId");
      this.bookService.getBooks(+libraryId).subscribe((data: Book[])=>{      
        console.log(data);
        this.books = data;
      })
  }

  addBook(): void {
    this.router.navigate(['add-book']);
  };

  editBook(book: Book): void{
    window.localStorage.removeItem("id");
    window.localStorage.setItem("id", book.id.toString());
    this.router.navigate(['edit-book']);
  }

  deleteBook(book: Book): void{    
    this.bookService.deleteBook(book.id)
    .subscribe( data => {
      this.books = this.books.filter(u => u !== book);
    })
  };

}
