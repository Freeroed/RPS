package domain;

import domain.Book;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-20T22:57:38")
@StaticMetamodel(Author.class)
public class Author_ { 

    public static volatile SingularAttribute<Author, String> country;
    public static volatile SingularAttribute<Author, Integer> id;
    public static volatile CollectionAttribute<Author, Book> bookCollection;
    public static volatile SingularAttribute<Author, String> fio;

}