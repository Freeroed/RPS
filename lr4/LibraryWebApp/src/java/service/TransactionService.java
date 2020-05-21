/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Author;
import domain.Book;
import domain.Library;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

/**
 *
 * @author Freeroed
 */
@Stateless
public class TransactionService {
    
    @EJB
    private BookService bookService;
    
    @EJB
    private AuthorService authorService;
    
    @EJB
    private LibraryService libraryService;
    
    @Transactional
    public void successTransact(Book book, Library library, Author author) {
      //  bookService.create(book);
        authorService.create(author);
        libraryService.create(library);
    }
    
    @Transactional
    public void rollBackTrasact(Book book, Library library, Author author) {
        bookService.create(book);
        authorService.create(author);
        libraryService.rollBack(library);
    }
    
    @Transactional
    public void throwException(Book book, Library library, Author author) {
        authorService.create(author);
        libraryService.create(library);
        bookService.throwEcxeprion(book);
    }
    
    @Transactional
    public void rollBackNoTransact(Book book, Library library, Author author) {
        //bookService.create(book);
        authorService.rollBack(author);
        libraryService.noTransact(library);
    }
    
    @Transactional
    public void newTransaction(Book book, Library library) {
        bookService.transact(book);
        libraryService.throwException(library);
    }
    
}
