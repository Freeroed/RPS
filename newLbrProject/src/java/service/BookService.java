/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Book;
import java.util.List;

/**
 *
 * @author Freeroed
 */
public interface BookService {
    public List<Book> findAll();
    
    public void create(Book book);
    
    public void edit(Book book);
    
    public void remove(Book book);
    
    public Book find(int id);
}
