/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import domain.Author;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import service.AuthorService;

/**
 *
 * @author Freeroed
 */
@Stateless
public class AuthorServiceImpl implements AuthorService{
     @PersistenceContext(unitName = "BookModulePU")
    private EntityManager entityManager;

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
    
}
