/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import domain.Book;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import service.BookService;

/**
 *
 * @author Freeroed
 */
@Stateless
public class BookServiceImpl implements BookService{
    
    @PersistenceContext(unitName = "testPU")
    private EntityManager entityManager;

    @Override
    public List<Book> findAll() {
        List<Book> result = entityManager.createQuery("SELECT u from Book u").getResultList();
        return result;
    }

    @Override
    public void create(Book book) {
        entityManager.persist(book);
    }

    @Override
    public void edit(Book book) {
        entityManager.merge(book);
    }

    @Override
    public void remove(Book book) {
        entityManager.remove(entityManager.merge(book));
    }

    @Override
    public Book find(int id) {
        return entityManager.find(Book.class, id);
    }
}
