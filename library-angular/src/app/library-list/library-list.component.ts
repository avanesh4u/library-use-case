import { Component, OnInit } from '@angular/core';
import { Library } from '../model/library';
import { Router } from '@angular/router';
import { BookService } from '../book.service';

@Component({
  selector: 'app-library-list',
  templateUrl: './library-list.component.html',
  styleUrls: ['./library-list.component.css']
})
export class LibraryListComponent implements OnInit {

  libraries: Library[] =[
    {
      "id": 1,      
      "name": "Core Java",
      "discription": "ABC",
      "location": "Head first",    
      }
  ];

  constructor(private router: Router, public bookService: BookService) { }

  ngOnInit(): void {
    this.bookService.getLibraries().subscribe((data: Library[])=>{
      
      console.log(data);
      this.libraries = data;
    })
  }

  goToBookStore(library: Library): void {
    window.localStorage.removeItem("libraryId");
    window.localStorage.setItem("libraryId", library.id.toString());
    this.router.navigate(['book-list']);
  };

}
