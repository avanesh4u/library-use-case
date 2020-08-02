import { Library } from './library'
export interface Book {
    id: number;
    code: string;
    title: string;
    author: string;
    publisher: string;
    pages: number;
    price: number;
    library: Library;

}
