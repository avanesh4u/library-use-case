export interface BookRequest {
    id: number;
    code: string;
    title: string;
    author: string;
    publisher: string;
    pages: number;
    price: number;
    libraryId: number;
}
