package spring.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import spring.dao.interfaces.BookDAO;
import spring.entities.Author;
import spring.entities.Book;
import spring.entities.Genre;

import java.util.List;

@Component
public class BookDAOImpl implements BookDAO {

    @Autowired
    private SessionFactory  sessionFactory;

    private List<Book> books;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Book> getBooks() {

        books = (List<Book>) sessionFactory.getCurrentSession()
                .createCriteria(Book.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return books;
    }

    public List<Book> getBooks(Author author) {
        return null;
    }

    public List<Book> getBooks(String bookName) {
        return null;
    }

    public List<Book> getBooks(Genre genre) {
        return null;
    }

    public List<Book> getBooks(Character letter) {
        return null;
    }

}
