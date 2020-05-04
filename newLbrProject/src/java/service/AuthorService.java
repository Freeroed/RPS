/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Author;
import java.util.List;

/**
 *
 * @author Freeroed
 */
public interface AuthorService {
        public List<Author> findAll();
       
       public Author find(int id);
       
       public void create(Author author);
       
       public void edit(Author author);
       
       public void remove(Author author);
}
