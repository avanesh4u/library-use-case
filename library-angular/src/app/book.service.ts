import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders, HttpErrorResponse } from "@angular/common/http";
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

import{ Book } from './model/Book';
import { Library } from './model/library';
import { BookRequest } from './model/book-request';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  private baseURL = "http://localhost:8080";
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(private httpClient: HttpClient) { }


  getLibraries():  Observable<Library[]> {
    return this.httpClient.get<Library[]>(this.baseURL+'/library/getLibraries');   
  }

  getBooks(libraryId: number): Observable<Book[]> {
    return this.httpClient.get<Book[]>(this.baseURL+'/book/getBooks/'+libraryId);   
  }

  addBook(book: BookRequest): Observable<Object> {    
    return this.httpClient.post(this.baseURL+'/book/add', book);
  }
  getBookById(id: number): Observable<Book> {
    return this.httpClient.get<Book>(this.baseURL+'/book/getBook/'+ id);
  }

  updateBook(book: BookRequest): Observable<Object> {
    return this.httpClient.put(this.baseURL+'/book/update', book);
  }

  deleteBook(id: number): Observable<Object> {
    return this.httpClient.delete<Book>(this.baseURL + '/book/delete/'+id);
  }
 

}
