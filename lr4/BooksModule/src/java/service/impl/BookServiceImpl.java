/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import domain.Book;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import service.BookService;

/**
 *
 * @author Freeroed
 */
@Stateless
public class BookServiceImpl implements BookService{
    
    @PersistenceContext(unitName = "BooksModulePU")
    private EntityManager entityManager;

    @Resource
    private SessionContext sessionContext;
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

    @Override
    public void throwEcxeprion(Book book) throws EJBException{
        entityManager.persist(book);
        throw new EJBException();
    }

    @Override
    public void rollBack(Book book) {
        entityManager.persist(book);
        sessionContext.setRollbackOnly();
    }

    @Override
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public void nonTransact(Book book) {
        entityManager.persist(book);
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void transact(Book book) {
        entityManager.persist(book);
    }
        
}
