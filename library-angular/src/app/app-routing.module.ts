import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BookListComponent } from './book-list/book-list.component';
import { AddBookComponent } from './add-book/add-book.component';
import { UpdateBookComponent } from './update-book/update-book.component';
import { LibraryListComponent } from './library-list/library-list.component';

const routes: Routes = [
  { path: '', component: LibraryListComponent, pathMatch: 'full' },
  { path: 'book-list', component: BookListComponent },
  { path: 'add-book', component: AddBookComponent },
  { path: 'edit-book', component: UpdateBookComponent } 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
