import { Component, OnInit } from '@angular/core';
import { Book } from '../model/Book';
import { BookService } from '../book.service';
import { Router } from '@angular/router';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import { Library } from '../model/library';
import { BookRequest } from '../model/book-request';

@Component({
  selector: 'app-update-book',
  templateUrl: './update-book.component.html',
  styleUrls: ['./update-book.component.css']
})
export class UpdateBookComponent implements OnInit {

  book: Book;
  bookBkp: Book;
  bookRequest: BookRequest;
  isUpdated = false;
  id: number;
  code: string;
  title: string;
  author: string;
  publisher: string;
  price: number;
  pages: number;
  libraryId: number;
  editForm: FormGroup;

  constructor(private formBuilder: FormBuilder, public bookService: BookService, private router: Router) { }

  ngOnInit(): void {
    let bookId = window.localStorage.getItem("id");
    this.editForm = this.formBuilder.group({
      id: [this.id],
      code: [this.code, Validators.compose([Validators.required]) ],
      title: [this.title, Validators.compose([Validators.required])],
      author: [this.author, Validators.compose([Validators.required])],
      publisher: [this.publisher, Validators.compose([ Validators.required])],
      price: [this.price, Validators.compose([Validators.required])],
      pages: [this.pages, Validators.compose([ Validators.required])],
    });


    this.bookService.getBookById(+bookId)
      .subscribe( data => {
        this.bookBkp = data;
        this.libraryId=data.library.id;
        this.editForm.patchValue(data);
      });

  }

  onSubmit(){
    this.isUpdated = true;
    this.save();
  }

  save(){
    this.bookRequest = this.editForm.value;
    this.bookRequest.libraryId = this.libraryId;
   // this.book.library =this.bookBkp.library;
   // this.book.libraryId=this.bookBkp.libraryId
      this.bookService.updateBook(this.bookRequest).subscribe( data =>
      console.log(data), error=> console.log(error) );
  }

}
