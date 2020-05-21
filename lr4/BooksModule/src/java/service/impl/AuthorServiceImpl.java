/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import domain.Author;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import service.AuthorService;

/**
 *
 * @author Freeroed
 */
@Stateless
public class AuthorServiceImpl implements AuthorService{
     @PersistenceContext(unitName = "BooksModulePU")
    private EntityManager entityManager;
     
    @Resource
    private SessionContext sessionContext;

    @Override
    public List<Author> findAll() {
        List<Author> result = entityManager.createQuery("SELECT u from Author u").getResultList();
        return result;
    }

    @Override
    public Author find(int id) {
        return entityManager.find(Author.class, id);
    }

    @Override
    public void create(Author author) {
        entityManager.persist(author);
    }

    @Override
    public void edit(Author author) {
        entityManager.merge(author);
    }

    @Override
    public void remove(Author author) {
        entityManager.remove(author);
    }

    @Override
    public void rollBack(Author author) {
        entityManager.persist(author);
        sessionContext.setRollbackOnly();
    }

    @Override
    public void thowExceprion(Author author) throws EJBException{
        entityManager.persist(author);
        throw new EJBException();
    }

    @Override
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public void noTrastact(Author author) {
        entityManager.persist(author);
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void transact(Author author) {
        entityManager.persist(author);
    }
    
    
    
}
