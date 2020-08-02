import { Component, OnInit } from '@angular/core';

import { Book } from '../model/Book';
import { BookService } from '../book.service';
import { Router } from '@angular/router';
import {FormBuilder, FormGroup, Validators, FormControl} from "@angular/forms";
import { Library } from '../model/library';
import { LibraryListComponent } from '../library-list/library-list.component';
import { BookRequest } from '../model/book-request';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, public bookService: BookService, private router: Router) { }

  addForm: FormGroup;
  submitted = false;
  library: Library;
  book: Book;
  bookRequest: BookRequest;
  code: string;
  title: string;
  author: string;
  publisher: string;
  price: number;
  pages: number;

  ngOnInit() {
    this.addForm = this.formBuilder.group({
      code: [this.code, Validators.required],
      title: [this.title, Validators.compose([Validators.required])],
      author: [this.author, Validators.compose([Validators.required])],
      publisher: [this.publisher, Validators.compose([ Validators.required])],
      price: [this.price, Validators.compose([Validators.required])],
      pages: [this.pages, Validators.compose([ Validators.required])],

    });
  }

  save(){
    let libraryId = window.localStorage.getItem("libraryId");
    this.bookRequest=this.addForm.value;
    this.bookRequest.libraryId=+libraryId;
    // this.book=this.addForm.value;
    // this.book.libraryId= +libraryId;
    //this.library={ id:+libraryId , name: "", discription:"", location:"" };
    //this.book.library=this.library;
    this.bookService.addBook(this.bookRequest).subscribe( data =>
      console.log(data), error=> console.log(error) );
     // this.goToBookList();
  }

  get f() {
        return this.addForm.controls;
    }

  onSubmit(){
    this.submitted = true;
    if (this.addForm.invalid) {
      this.submitted = false;
      return;
    }
    this.save();
  }

}
